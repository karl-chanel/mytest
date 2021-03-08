package hello;

import org.w3c.dom.Node;

/**
 * @author 86176
 * @package hello
 * @date 2021/2/18 10:19
 */
public class TeatAno {

    static volatile boolean flag = true;

    public static void main(String[] args) {
        Node node = new Node();
        int t =10;
        new Thread(() -> {
            int counter = 0;
            System.out.println(t);
            while (true) {
                System.out.println(node.a+"     ->"+counter);
                counter++;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();



    }
        public static class Node {
            public int a = 1;
        }
}