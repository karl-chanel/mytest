package hello;

/**
 * @author 86176
 * @package hello
 * @date 2021/2/20 2:59
 */
public class yuyu {
    private static int i =4;
    public static void main(String[] args) {
       Runnable r = new Runnable(){
            @Override
            public void run() {
                int counter = 0;
                while (true) {
                System.out.println("hi"+i+"      :"+counter);
                    try {
                        counter++;
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(r).start();
        new yuyu().foo(i);
        System.out.println("hi");
    }
    public int neg(int i) {
        System.out.println("inside the neg"+i);
        return -i;
    }

    public int foo(int i) {
        getClass().getClassLoader();
        return neg(neg(neg(i)));
    }
}
