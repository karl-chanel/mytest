package dope;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 86176
 * @package dope
 * @date 2021/2/21 20:12
 */
public class readwritelock {
    private final ReadWriteLock locktest = new ReentrantReadWriteLock();
    private final Lock relock = locktest.readLock();
    private final Lock wrlock = locktest.writeLock();
    public ArrayList<String> arrayList = new ArrayList<>();
    public void add(String s){
        wrlock.lock();
        try {
            arrayList.add(s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            wrlock.unlock();
        }
    }
    public String get(int index) {
        relock.lock();
        try {
            return arrayList.get(index);
        } finally {
            relock.unlock();
        }
    }
    public  boolean isempty(){
        if (arrayList.isEmpty()){
            return true;
        }
        return false;
    }


    public static void main(String[] args) throws InterruptedException {
        readwritelock t = new readwritelock();
        new Thread(() -> {
            int c = 0;
            for(;;){
               t.add(""+c);
               c++;
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for(int c = 0;;){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(t.get(c));
                c++;
            }
        }).start();
//        Thread.sleep(10000);
    }

}
