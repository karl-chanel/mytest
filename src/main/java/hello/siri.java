package hello;

import java.util.Date;
import java.util.concurrent.Executors;

/**
 * @author 86176
 * @package hello
 * @date 2021/2/20 20:46
 */
public class siri {

    static {
        init();
    }

    private static void init() {
        java.util.Date d = new java.sql.Date(System.currentTimeMillis());
        new siri().test();
        System.out.println("=======================================");
        siri.main(new String[]{"cf","fc"});
        System.out.println("=======================================");
    }


    public static void main(String[] args) {
        Executors.newFixedThreadPool(10);
        new Date(System.currentTimeMillis());
        ClassLoader loader = siri.class.getClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
        // System.out.println(loader.getParent().getParent().getParent());
    }
    public void test(){
        System.out.println("test!");
    }
}
