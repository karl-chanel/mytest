package dope;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 86176
 * @package dope
 * @date 2021/2/21 17:47
 */

public class cunt4 {
    public static Object o1 = new Object();
    public static Object o2 = new Object();
    public static void main(String[] args) {
//        Counter5 t1 = new Counter5();
//        Counter5 t2 = new Counter5();
//        new Thread(() -> t1.add(100)).start();
//        new Thread(() -> t1.dec(100)).start();
//        new Thread(() -> t2.add(100)).start();
//        new Thread(() -> t2.dec(100)).start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("t1.count = " + t1.get());
//        System.out.println("t2.count = " + t2.get());
        AtomicReference<test> t = new AtomicReference<>(new test());
        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.get().h1();
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.get().h2();
        }).start();
    }
}
class  test{
    public void h1() {
        synchronized (cunt4.o1) {
            System.out.println("test.h1");
            System.out.println(Thread.currentThread());
            System.out.println("get o1 lock"+Thread.currentThread().getName());
            System.out.println("trying getting o2 lock");
            synchronized (cunt4.o2) {
                System.out.println("get o2 lock");
            }
        }
    }

    public void h2(){
        synchronized (cunt4.o2) {
            System.out.println("test.h2");
            System.out.println(Thread.currentThread());
            System.out.println("get o2 lock"+Thread.currentThread().getName());
            System.out.println("trying getting o1 lock");
            synchronized (cunt4.o1) {
                System.out.println("get o1 lock");
            }
        }
        }


}
class Counter5{
    private int count = 0;
    public synchronized void add(int n){
        count += n;
    }
    public synchronized void dec(int n){
        count -= n;
    }
    public int get(){
        return count;
    }
}