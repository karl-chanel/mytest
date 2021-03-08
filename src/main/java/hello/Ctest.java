package hello;

import java.lang.reflect.Array;
import java.lang.reflect.Type;

/**
 * @author 86176
 * @package hello
 * @date 2021/2/18 8:57
 */


class Candy {
    static {   System.out.println("Loading Candy"); }
}

class Gum {
    static {   System.out.println("Loading Gum"); }
}

class Cookie {
    static {   System.out.println("Loading Cookie"); }
}

public class Ctest {
    static {
        System.out.println("main is running");

    }
    public static void print(Object obj) {
        System.out.println(obj);
    }
    public static void main(String[] args) throws ClassNotFoundException {

                int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
                Class<?> clazz = array.getClass().getComponentType();
                Object newArr = Array.newInstance(clazz, 15);
                int co = Array.getLength(array);
                System.arraycopy(array, 0, newArr, 0, co);
                for (int i:(int[]) newArr) {
                    System.out.print(i+",");
                }

                Class clazz2 = Class.forName("java.lang.String");

                Object array2 = Array.newInstance(clazz2, 10);

                Array.set(array2, 6, "hello world!");

                String str = (String)Array.get(array2, 6);
                System.out.println();
                System.out.println(str);
            }

        }

