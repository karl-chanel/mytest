package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 86176
 * @package io
 * @date 2021/2/24 22:04
 */
public class nio {
    public static void main(String[] args) throws IOException {
//        String msg = "java技术爱好者，起飞！";
//        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//        byte[] bytes = msg.getBytes();
//        byteBuffer.put(bytes);
//        byteBuffer.flip();
//        byte[] tempByte = new byte[bytes.length];
//        int i = 0;
//        while (byteBuffer.hasRemaining()) {
//            byte b = byteBuffer.get();
//            tempByte[i] = b;
//            i++;
//        }
//        System.out.println(new String(tempByte));
        FileInputStream in = new FileInputStream("src\\main\\resources\\app.log");
        FileChannel ch = in.getChannel();
        FileOutputStream fou = new FileOutputStream("src\\test.log");
        FileChannel ch1 = fou.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        ch.read(buffer);
        System.out.println(new String(buffer.array()));
        buffer.flip();
        System.out.println(new String(buffer.array()));
       // ch1.write(buffer);
        fou.close();
        in.close();
        ch1.close();
        ch.close();


    }
}
