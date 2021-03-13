package singgle;

/**
 * @author 86176
 * @package singgle
 * @date 2021/3/12 19:14
 */
public class SingleTest {
    public static void main(String[] args) throws ClassNotFoundException {
      //  Class.forName("singgle.Singleton");
        Singleton s = null;
        System.out.println(Singleton.class);
        s = Singleton.getInstance(); // create singleton instance...
        System.out.println(s);
    }
}
