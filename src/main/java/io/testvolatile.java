package io;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @author 86176
 * @package io
 * @date 2021/2/25 15:47
 */
public class testvolatile {
    private static final AtomicInteger a = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException, IOException {
        File file = new File("ftr");
        FileWriter w = new FileWriter("hh");
        Thread[] ts = new Thread[10];
        Stream<Thread> s = Arrays.stream(ts).map(t -> {
            return t = new mythread();
        });
        s.forEach(Thread::start);
        Thread.sleep(2000);
        System.out.println(a.get());
    }

    static class mythread extends Thread {
        @Override
        public void run() {
            for (int j = 0; j < 100000; j++) {
                a.incrementAndGet();
            }
        }
    }
}
