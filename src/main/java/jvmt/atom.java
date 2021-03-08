package jvmt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 86176
 * @package jvmt
 * @date 2021/2/23 20:38
 */
public class atom {
    static AtomicInteger i=new AtomicInteger();
    static AtomicIntegerArray a = new AtomicIntegerArray(15);

    public static class AddThread implements Runnable{
        public void run(){
            for(int k=0;k<100000;k++)
                i.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = new ThreadPoolExecutor(10, 20, 10, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        Thread[] ts=new Thread[10];
        //开启10条线程同时执行i的自增操作
        for(int k=0;k<10;k++){
            ts[k]=new Thread(new AddThread());
        }
        //启动线程
        for(int k=0;k<10;k++){ts[k].start();}

        for(int k=0;k<10;k++){ts[k].join();}

        System.out.println(i);
    }
}
