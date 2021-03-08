package jvmt;

//import  sun.jvm.hotspot.runtime.ObjectMonitor;
import org.openjdk.jol.info.ClassLayout;
import sun.misc.Unsafe;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author 86176
 * @package jvmt
 * @date 2021/2/23 11:40
 */
public class biasedtest {



    void cantBeZero(int i) throws Exception{
        if(i==0){
         throw new Exception();}
    }


    private  static  Object o =new Object();


    public static void main(String[] args) throws InterruptedException {

//        String s = """
//        hello
//        bitches
//        loop in the
//        cardiac
//        mixlab
//        """;
//
//        Object o = new Object();
//        System.out.println(s);
//        System.out.println(ClassLayout.parseInstance(o).toPrintable());
//        synchronized (o) {
//        System.out.println(ClassLayout.parseInstance(o).toPrintable());
//        }
        Thread t = new Thread(() -> {
            try {
                System.out.println("inside the first rhread");
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                new Thread(() -> {
                    System.out.println("inside the second thread");
                    for (int i = 0; i < 100; i++) {
                        System.out.println(Thread.currentThread().getName()+"     :"+i);
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                    }
                }).start();
            }
        });
        t.start();
        t.interrupt();
        Thread.sleep(5000);


    }
}
