package hello;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 86176
 * @package hello
 * @date 2021/2/17 16:40
 */
public class MethodsTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException{
        Class<?> std = Studentm.class;
        Method m1 = std.getMethod("getScore", String.class);
        Method m2 = std.getDeclaredMethod("getGrade", int.class);
        System.out.println(m1);
        System.out.println(m2);
//        m2.setAccessible(true);
        try {
            System.out.println(m2.invoke(null, 10));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String s = "Hello world";
        // 获取String substring(int)方法，参数为int:
        Method m = String.class.getMethod("substring", int.class);
        // 在s对象上调用该方法并获取结果:
        String r = null;
        try {
            r = (String) m.invoke(s, 6);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 打印调用结果:
        System.out.println(r);
        System.out.println("-----------------------------------");
        Method ms= Integer.class.getMethod("parseInt", String.class);
        // 调用该静态方法并获取结果:
        Integer n = null;
        try {
            n = (Integer) ms.invoke(null, "12345");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        // 打印调用结果:
        System.out.println(n);

    }
static class Studentm extends Personm {
    public int getScore(String type) {
        return 99;
    }
    private static int getGrade(int year) {
        return 1;
    }
}

static class Personm {
    public String getName() {
        return "Person";
    }
}
}
