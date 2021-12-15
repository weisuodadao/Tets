package src.Nthread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Lock
 * @Description:
 * @Author xianzhuo
 * @Date 2021/11/21 6:17 下午
 * @Version V1.0
 **/
public class ReLock {

    private int count;

    private int state;

    private Lock lock = new ReentrantLock();

    public ReLock(int count) {
        this.count = count;
    }

    private void print(String name, int target) {
        for (int i = 0; i < count; i++) {
            lock.lock();
            if (state % 3 == target) {
                state++;
                i++;
                System.out.println(name);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReLock reLock = new ReLock(10);
        new Thread(() -> {
            reLock.print("1", 0);
        }, "1").start();
        new Thread(() -> {
            reLock.print("2", 1);
        }, "2").start();
        new Thread(() -> {
            reLock.print("3", 2);
        }, "3").start();
    }
}
