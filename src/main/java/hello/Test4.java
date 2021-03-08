package hello;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * @author 86176
 * @package hello
 * @date 2021/2/17 22:00
 */

public class Test4 {
//    public static void main(String[] args) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
//        ArrayList<Integer> arrayList3=new ArrayList<Integer>();
//        arrayList3.add(1);//这样调用add方法只能存储整形，因为泛型类型的实例为Integer
//        arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3, "asd");
//        for (Integer integer : arrayList3) {
//            System.out.println(integer);
//        }
//    }
    public static void main(String[] args) {
        /**不指定泛型的时候*/

        int i=Test4.add(1, 2); //这两个参数都是Integer，所以T为Integer类型
        Number f=Test4.add(1, 1.2);//这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Number
        Object o=Test4.add(1, "asd");//这两个参数一个是Integer，以风格是Float，所以取同一父类的最小级，为Object

        int a=Test4.<Integer>add(1, 2);//指定了Integer，所以只能为Integer类型或者其子类
//        int b=Test4.<Integer>add(1, 2.2);//编译错误，指定了Integer，不能为Float
        Number c=Test4.<Number>add(1, 2.2); //指定为Number，所以可以为Integer和Float
    }

    //这是一个简单的泛型方法
    public static <T> T add(T x,T y){
        return y;
    }
}
