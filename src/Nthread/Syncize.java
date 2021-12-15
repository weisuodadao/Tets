package src.Nthread;

/**
 * @ClassName Syncize
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/11/21 6:38 下午
 * @Version V1.0
 **/
public class Syncize {

    private int state;

    private int count;

    private static final Object LOCK = new Object();

    public Syncize(int count) {
        this.count = count;
    }

    private void print(String name, int target) {
        for (int i = 0; i < count; i++) {
            synchronized (LOCK) {
                while (state % 3 == target) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                state++;
                System.out.println(name);
                LOCK.notify();
            }
        }
    }

    public static void main(String[] args) {
        Syncize s = new Syncize(10);
        new Thread(() -> {
            s.print("1", 0);
        }, "1").start();
        new Thread(() -> {
            s.print("2", 1);
        }, "2").start();
        new Thread(() -> {
            s.print("3", 2);
        }, "3").start();
    }
}
