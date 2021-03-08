package netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 86176
 * @package netty
 * @date 2021/2/27 22:47
 */
public class p {
    private HashMap<SocketAddress, String> map = new HashMap<>();
    private int c = 1;
    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    public static final int PORT = 6667;

    //构造器初始化成员变量
    public p() {
        try {
            //打开一个选择器
            this.selector = Selector.open();
            //打开serverSocketChannel
            this.serverSocketChannel = ServerSocketChannel.open();
            //绑定地址，端口号
            this.serverSocketChannel.bind(new InetSocketAddress(PORT));
            //设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            //把通道注册到选择器中
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 监听，并且接受客户端消息，转发到其他客户端
     */
    public void listen() {
        try {
            while (true) {
                //获取监听的事件总数
                int count = selector.select(2000);
                if (count > 0) {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    //获取SelectionKey集合
                    Iterator<SelectionKey> it = selectionKeys.iterator();
                    while (it.hasNext()) {
                        SelectionKey key = it.next();
                        //如果是获取连接事件
                        if (key.isAcceptable()) {
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            //设置为非阻塞
                            socketChannel.configureBlocking(false);
                            //注册到选择器中
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            SocketAddress a = socketChannel.getRemoteAddress();
                            map.put(a, "user" +c);
                            System.out.println(map.get(a) + "上线了~");
                            c++;
                        }
                        //如果是读就绪事件
                        if (key.isReadable()) {
                            //读取消息，并且转发到其他客户端
                            readData(key);
                        }
                        it.remove();
                    }
                } else {
                    // System.out.println("等待...");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取客户端发送过来的消息
    private void readData(SelectionKey selectionKey) {

        SocketChannel socketChannel = null;
        try {
            //从selectionKey中获取channel
            socketChannel = (SocketChannel) selectionKey.channel();
            //创建一个缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //把通道的数据写入到缓冲区
            int count = socketChannel.read(byteBuffer);
            if (count==-1) {
                throw  new IOException();
            }
            //判断返回的count是否大于0，大于0表示读取到了数据
            if (count > 0) {
                //把缓冲区的byte[]转成字符串
                String msg = "\n>>>" + new String(byteBuffer.array()) + "\n";
                //输出该消息到控制台
                System.out.println("from 客户端：" + msg);
                //转发到其他客户端
                System.out.println(map.get(socketChannel.getRemoteAddress()));
                notifyAllClient(msg, socketChannel);
            }
        } catch (IOException e) {
            try {
                //打印离线的通知
                System.out.println(map.get(socketChannel.getRemoteAddress())+ "离线了...");
                //取消注册
                selectionKey.cancel();
                //关闭流
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * 转发消息到其他客户端
     * msg 消息
     * noNotifyChannel 不需要通知的Channel
     */
    private void notifyAllClient(String msg, SocketChannel noNotifyChannel)  {
        System.out.println("服务器转发消息~");
        for (SelectionKey selectionKey : selector.keys()) {
            Channel channel = selectionKey.channel();
            //channel的类型实际类型是SocketChannel，并且排除不需要通知的通道
            if (channel instanceof SocketChannel && channel != noNotifyChannel) {
                //强转成SocketChannel类型
                SocketChannel s = (SocketChannel) channel;
                //通过消息，包裹获取一个缓冲区
                ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
                try {
                    s.write(byteBuffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        p chatServer = new p();
        //启动服务器，监听
        chatServer.listen();
    }
}
