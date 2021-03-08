package dope;

import java.time.LocalTime;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author 86176
 * @package dope
 * @date 2021/2/21 16:03
 */
public class cunt1 {
    public static void main(String[] args)  throws InterruptedException {
         Object o = new Object();
         int i = 10;
        helloThread1 t = new helloThread1();
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println(o);
                System.out.println(i);
            }
        };
        Runnable r = new MyRunnable();
        Thread thread = new Thread(r);
       // thread.setDaemon(true);
        thread.start();
        t.start();
        Thread.sleep(10);
        t.running=false;  // 标志位置为false
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println(LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class helloThread1 extends Thread {
    public volatile boolean running = true;
   // public AtomicBoolean running = new AtomicBoolean(true);
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " hello!");
        }
        System.out.println("end!");
    }
}

