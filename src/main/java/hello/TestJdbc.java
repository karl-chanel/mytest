package hello;
import com.mysql.cj.jdbc.Driver;
/**
 * @author 86176
 * @package hello
 * @date 2021/2/20 17:36
 */
public class TestJdbc {
    public static void main(String[] args) throws ClassNotFoundException {
         Class.forName("com.mysql.cj.jdbc.Driver");

    }
}
