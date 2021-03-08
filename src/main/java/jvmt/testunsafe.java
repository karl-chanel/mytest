package jvmt;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author 86176
 * @package jvmt
 * @date 2021/2/23 19:42
 */
public class testunsafe {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
//        Unsafe un = Unsafe.getUnsafe();
//        System.out.println(un);
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        System.out.println(unsafe);
        User user = (User) unsafe.allocateInstance(User.class);
        Class<?> userClass = user.getClass();
        Field name = userClass.getDeclaredField("name");
        Field age = userClass.getDeclaredField("age");
        Field id = userClass.getDeclaredField("id");
        unsafe.putInt(user,unsafe.objectFieldOffset(age),18);
        unsafe.putObject(user,unsafe.objectFieldOffset(name),"android TV");

        Object staticBase = unsafe.staticFieldBase(id);
        System.out.println("staticBase:"+staticBase);
        long data = 1000;
        byte size = 1;//单位字节

        //调用allocateMemory分配内存,并获取内存地址memoryAddress
        long memoryAddress = unsafe.allocateMemory(size);
        //直接往内存写入数据
        unsafe.putAddress(memoryAddress, data);
        //获取指定内存地址的数据
        long addrData=unsafe.getAddress(memoryAddress);
        System.out.println("addrData:"+addrData);


    }
}
class User{
    public User(){
        System.out.println("user 构造方法被调用");
    }
    private String name;
    private int age;
    private static String id="USER_ID";

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +'\'' +
                ", id=" + id +'\'' +
                '}';
    }
}