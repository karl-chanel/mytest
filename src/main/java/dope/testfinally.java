package dope;

import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 86176
 * @package dope
 * @date 2021/2/21 19:55
 */
public class testfinally {
    private  static final AtomicInteger i = new AtomicInteger();
    public static void main(String[] args) {
//        ExecutorService ex = Executors.newFixedThreadPool(5);
//        ScheduledThreadPoolExecutor se = new ScheduledThreadPoolExecutor(10);
//        se.scheduleAtFixedRate(testfinally::run, 2, 1, TimeUnit.SECONDS);
//        se.scheduleAtFixedRate(testfinally::run2, 2, 1, TimeUnit.SECONDS);
//        Future<String> future = ex.submit(testfinally::call);
//        try {
//            System.out.println(future.get());
//            throw new InterruptedException("test exception");
//        } catch (InterruptedException | ExecutionException e) {
//            String message = e.getMessage();
//            System.out.println("throw exception!!     "+message);
//        }
//        ex.shutdown();
//        Stream<Integer> st = Stream.generate(new NatualSupplier());
//        st.limit(10).map(integer -> Math.multiplyExact(integer, integer)).forEach(System.out::println);
        List<String> props = List.of("profile=native", "debug=true", "logging=warn", "interval=500");
        Map<String, String> map = props.stream()
                .map(kv -> {
                    String[] ss = kv.split("\\=", 2);
                    return Map.of(ss[0], ss[1]);
                })
                .reduce(new HashMap<String,String>(), (stringStringMap, stringStringMap2) -> {
                    stringStringMap.putAll(stringStringMap2);
                    return stringStringMap;
                });
        map.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
        // System.out.println(integer);
        int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(Integer.valueOf("10"), Integer::sum);
        System.out.println(sum); // 45
        List<String> list = List.of("Apple", "Banana", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots");
        Map<String, List<String>> groups = list.stream()
                .collect(Collectors.groupingBy(s -> s.substring(0, 1), Collectors.toList()));
        System.out.println(groups);





//
//
//        Stream.generate(new LocalDateSupplier())
//                .limit(60)
//                .filter(ldt -> ldt.getDayOfWeek() == DayOfWeek.SATURDAY || ldt.getDayOfWeek() == DayOfWeek.SUNDAY)
//                .forEach(System.out::println);
//        String[] s = {"hello","mike","loop","judas"};
//        System.out.println(Arrays.toString(s));
//        Arrays.sort(s, String::compareTo);
//        System.out.println(Arrays.toString(s));
//        Stream<Integer> naturals = List.of(15,20,50,30).stream();
//        naturals.map(n -> n*n)
//                .forEach(System.out::println);
//        Stream<String> stream1 = Arrays.stream(new String[] { "A", "B", "C" });
//        Stream<String> stream2 = List.of("X", "Y", "Z").stream();
//        stream1.forEach(System.out::println);
//        stream2.forEach(System.out::println);
//      for (int i = 0; i < 10; i++) {
//          ex.submit(() -> {
//            System.out.println(Thread.currentThread());
//          });
//        }
//      ex.shutdown();
    }
    public static String test(){
        try {
            System.out.println("inside the try");
            throw new Exception("testing out");
        } catch (Exception e) {
//          System.out.println(e.getMessage());
            System.out.println("inside the catch");
            return "test";
        }finally {
            System.out.println("inside the finally");
        }
    }

    private static void run() {
        synchronized (i) {
            System.out.println("inside the se task1  :" + i);
            i.incrementAndGet();
        }
    }

    private static void run2() {
        synchronized (i) {
        System.out.println("inside the se task2   :" + i);
        i.incrementAndGet();
        }
    }

    private static String call() {
        System.out.println("testing callable");
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "kiki";
    }
    public  static  boolean  ttt(){
        System.out.println("jjjj");
        return true;
    }
}
class NatualSupplier implements Supplier<Integer> {
    int n = 0;
    public Integer get() {
        n++;
        return n;
    }
}
class LocalDateSupplier implements Supplier<LocalDate> {
    LocalDate start = LocalDate.of(2021, 1, 1);
    int n = -1;
    public LocalDate get() {
        n++;
        return start.plusDays(n);
    }
}