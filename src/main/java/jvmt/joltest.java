package jvmt;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;
import sun.misc.Unsafe;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author 86176
 * @package jvmt
 * @date 2021/2/22 17:00
 */
public class joltest {
    public static void main(String[] args) throws InterruptedException {


        Thread.interrupted();
        String[] ins = {"ddc","dscdsc","ytht"};
        Person person = new Person();
        System.out.println(ClassLayout.parseInstance(person).toPrintable());
        String s = "ff0";
        System.out.println(ClassLayout.parseInstance(s).toPrintable());
        Thread.sleep(5000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (person){
                    //当前锁对象第一次被线程获取
                    System.out.println(ClassLayout.parseInstance(person).toPrintable());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        person.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("end of thread 1");
                    System.out.println(ClassLayout.parseInstance(person).toPrintable());
                    System.out.println("==============================================================");
                    System.out.println(VM.current().details());
                    System.out.println("==============================================================");
                    System.out.println(GraphLayout.parseInstance(person).toPrintable());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (person){
                    //当前锁对象第一次被线程获取
                    System.out.println(ClassLayout.parseInstance(person).toPrintable());
                    person.notifyAll();
                }
            }
        }).start();

        Thread.sleep(7000);
        System.out.println("55555555555555555555555555555555555555555555555555555500");
        System.out.println(ClassLayout.parseInstance(person).toPrintable());
        synchronized(person){
        System.out.println(ClassLayout.parseInstance(person).toPrintable());
        }



        //查看对象内部信息
//        print(ClassLayout.parseInstance(ins).toPrintable());
//
//        //查看对象外部信息
//       print(GraphLayout.parseInstance(ins).toPrintable());
//
//        //获取对象总大小
//       print("size : " + GraphLayout.parseInstance(ins).totalSize());
    }
    static void print(String message) {
        System.out.println(message);
        System.out.println("-------------------------");
    }

    static Object generate() {
        Map<String, Object> map = new HashMap<>();
        map.put("a", Integer.valueOf("10"));
        map.put("b", "b");
        map.put("c", LocalDate.now());
        return map;
    }
}
 class Person {
    String str = "test";
    Son son = new Son();
}
class Son{
}