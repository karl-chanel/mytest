package hello;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.BasicConfigurator;
/**
 * @author 86176
 * @package hello
 * @date 2021/2/17 0:05
 */
public class FSE {
    private static Logger log = Logger.getLogger(FSE.class.getClass());
    public static void main(String[] args) throws Exception {
//          Log l = LogFactory.getLog(FSE.class);
          log.info("starting logging!!!!,INFO LEVEL");
          log.error("testing error");
          log.error("testing error");
          log.error("testing error");
//        Exception origin = null;
//        try {
//            System.out.println(Integer.parseInt("abc"));
//        } catch (Exception e) {
//            origin = e;
//            throw e;
//        } finally {
//            Exception e1 = new IllegalArgumentException();
//            if (origin != null) {
//                e1.addSuppressed(origin);
//            }
//            throw e1;
//        }
    }
//    static void process1() {
//        process2();
//    }
//
//    static void process2() {
//        Integer.parseInt(null); // 会抛出NumberFormatException
//    }
}
