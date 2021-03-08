package dope;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author 86176
 * @package dope
 * @date 2021/2/22 1:07
 */
public class futurete {
    private static final InheritableThreadLocal<String> it = new InheritableThreadLocal<>();
    private static  final  ThreadLocal<String> t = new ThreadLocal<>();
    public static void main(String[] args) {
//        CompletableFuture<String> c;
//        c = CompletableFuture.supplyAsync(futurete::get);
//        c.thenAccept(System.out::println);
//        c.exceptionally(futurete::apply);
        it.set("iherit ");
        t.set("test out");

        new futurete().test();
        new Thread(new Runnable() {
            public void test(){
                System.out.println(t.get());
                System.out.println(it.get());
                it.set("pp");
                System.out.println(it.get());
            }
            @Override
            public void run() {
                t.set("inside the child ");
                test();
            }
        }).start();
    }
    public void test(){
        System.out.println(t.get());
        System.out.println(it.get());
    }

    private static String get() {
//        throw  new Exception("ppppppp");
        return "hi loop !";
    }

    private static String apply(Throwable throwable) {
        System.out.println(throwable.getMessage());
        return "processing over";
    }
}
