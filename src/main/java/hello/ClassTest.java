package hello;

/**
 * @author 86176
 * @package hello
 * @date 2021/2/17 15:51
 */
public class ClassTest {
    public void foo() {
        Object o = new Object();
    }

    public static void main(String[] args) {
        String S1 = new String("test");
        printClassInfo("HH".getClass());
        printClassInfo(Runnable.class);
        printClassInfo(java.time.Month.class);
        printClassInfo(String[].class);
        String s2 = new String("test1");
        printClassInfo(int.class);
    }

    static void printClassInfo(Class<?> cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
