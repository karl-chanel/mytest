package singgle;

/**
 * @author 86176
 * @package singgle
 * @date 2021/3/12 19:04
 */
public class Singleton {

    static {
        System.out.println("init Singleton class...");
    }

    private static Singleton instance = createInstance();

    private static Singleton createInstance() {
        System.out.println("create singleton instance...");
        return new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("single.Singleton");
        Singleton s = null;
        System.out.println(Singleton.class);
        s = Singleton.getInstance(); // create singleton instance...
        System.out.println(s);
    }
}
