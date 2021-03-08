package hello;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 86176
 * @package hello
 * @date 2021/2/17 23:51
 */
public class Outer {
    private int outProp = 8;
    class Inner {
        private int inProp = 5;
    }

    public void accessInnerProp() {
        Inner in = new Inner();
        Class<?> clazz = in.getClass();
        System.out.println(clazz.getName());

        Field[] fs = clazz.getDeclaredFields();
        for (Field f :  fs) {
            try {
                System.out.println(f.getName()+"  :   "+f.get(in));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        Method[] ms = clazz.getDeclaredMethods();
        for (Method m : ms) {
            System.out.println(m.getName());
        }
        Constructor<?>[] cs;
        cs = clazz.getDeclaredConstructors();
        for (Constructor<?> c : cs) {
            System.out.println(c);
        }
        System.out.println(in.inProp);
    }

    public static void main(String[] args) {
        Outer p = new Outer();
        p.accessInnerProp();
    }
}
