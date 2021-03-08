package jvmt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 86176
 * @package jvmt
 * @date 2021/2/23 21:54
 */
public class refer {
    private static final SpinLock lock = new SpinLock();
    private static int test = 0;
    public static void main(String[] args) throws InterruptedException {
        tt();
        tt();
        tt();
        Thread.sleep(2000);
        System.out.println(test);
            }

    public static void tt() throws InterruptedException {
       Thread t = new Thread(() -> {
            lock.lock();
            for (int i = 0; i < 100; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                test++;
            }
            lock.unlock();
        });
       t.start();
       t.join();
    }


    static class SpinLock {
        private final AtomicReference<Thread> sign =new AtomicReference<>();

        public void lock(){
            Thread current = Thread.currentThread();
            while(!sign.compareAndSet(null, current)){
                System.out.println( Thread.currentThread().getName()+" is trying locking");
            }
        }

        public void unlock (){
            Thread current = Thread.currentThread();
            sign .compareAndSet(current, null);
        }
    }
}
