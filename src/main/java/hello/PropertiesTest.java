package hello;

import java.io.*;
import java.util.Properties;
import java.util.zip.InflaterInputStream;

/**
 * @author 86176
 * @package hello
 * @date 2021/2/18 16:25
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties p = new Properties();
//        p.load(new FileInputStream(new File("C:\\Users\\86176\\IdeaProjects\\webapps\\src\\main\\resources\\log4j.properties")));
//        p.load(new FileInputStream(new File("/src/main/resources/log4j.properties")));
        p.load(PropertiesTest.class.getResourceAsStream("/log4j.properties"));
        System.out.println(System.getProperty("user.dir"));
        InputStream in =PropertiesTest.class.getResourceAsStream("/test/hello.txt");
        InputStreamReader re = new InputStreamReader(in);
        String results = "";
        int tmp;
        while((tmp = re.read()) != -1){
            results += (char)tmp;
        }
        System.out.println(results);
        System.out.println(p.getProperty("log4j.rootLogger"));
        System.out.println(p);
    }
}
