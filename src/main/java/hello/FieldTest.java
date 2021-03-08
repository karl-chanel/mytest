package hello;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author 86176
 * @package hello
 * @date 2021/2/17 16:15
 */
public class FieldTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Object p = new Personf("Xiao Ming");
        Class<?> c = p.getClass();
        System.out.println(c);
        Field f = c.getDeclaredField("name");
        Field[] fs = c.getFields();
        for (Field field : fs) {
            System.out.println(field.getName());
        }
        System.out.println(f.getModifiers());
        int r = f.getModifiers();
        System.out.println(Modifier.isPrivate(r));
        Object value = f.get(p);
        System.out.println(value); // "Xiao Ming"
        f.set(p, "mike vivi");
        System.out.println(f.get(p));
    }



   static class Personf{
        private String name;

        public Personf(String name) {
            this.name = name;
        }
    }
}
