package dope;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/***
 * @author 86176
 * @package dope
 * @date 2021/2/21 18:57
 *
 */

public class cunt5 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("ite a");
        var q = new TaskQueue();
        var ts = new ArrayList<Thread>();
        for (int i=0; i<5; i++) {
            var t = new Thread(() -> {
                while (true) {
                    String s = null;
                    try {
                        s = q.getTask();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("execute task: " + s +"    :" +Thread.currentThread().getName());
                }
            });
            t.start();
            ts.add(t);
        }
        var add = new Thread(() -> {
            for (;;) {
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                try { Thread.sleep(1000); }
                catch(InterruptedException e) {

                }
            }
        });
        add.start();
        add.join();
//        Thread.sleep(100);
//        for (var t : ts) {
//            t.interrupt();
//        }
    }
    }
    class TaskQueue {
        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();
        private final Queue<String> queue = new LinkedList<>();
        public void addTask(String s) {
            lock.lock();
            try {
                queue.add(s);
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
        public String getTask() throws InterruptedException {
            lock.lock();
            try {
                while (queue.isEmpty()) {
                        condition.await();
                }
                return queue.remove();
            } finally {
                lock.unlock();
            }
        }
}