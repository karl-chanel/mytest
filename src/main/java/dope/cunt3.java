package dope;

/**
 * @author 86176
 * @package dope
 * @date 2021/2/21 16:35
 */
public class cunt3 {
    public synchronized static void  main(String[] args) throws Exception {
        var add = new AddThread();
        var dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
        var s = "fiefs";
    }
}

class  Counter {
    public static  Object o;

    static {
        o = new Object();
    }

    public static int count = 0;
}

class AddThread extends Thread {
    public  void  run() {
        for (int i=0; i<10000; i++) {
            synchronized (Counter.class) {
            Counter.count += 1; }
            }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.class) {
                Counter.count -= 1;
            }
        }
    }
}
