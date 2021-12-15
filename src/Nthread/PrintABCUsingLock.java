package src.Nthread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName PrintABCUsingLock
 * @Description: 使用 Lock
 * @Author xianzhuo
 * @Date 2021/7/27 5:34 下午
 * @Version V1.0
 * 使用一个取模的判断逻辑 C%M ==N，题为 3 个线程，所以可以按取模结果编号：0、1、2，他们与 3 取模结果仍为本身，则执行打印逻辑
 *
 *
 * main 方法启动后，3 个线程会抢锁，但是 state 的初始值为 0，所以第一次执行 if  语句的内容只能是 线程 A，然后还在 for 循环之内，此时 state = 1，
 * 只有 线程 B 才满足 1% 3 == 1，所以第二个执行的是 B，同理只有 线程 C 才满足 2% 3 == 2，所以第三个执行的是 C，执行完 ABC 之后，
 * 才去执行第二次 for 循环，所以要把 i++ 写在 for 循环里边，不能写成 for (int i = 0; i < times;i++)  这样
 **/
public class PrintABCUsingLock {

    // 控制打印次数
    private int times;

    // 当前状态值：保证三个线程之间交替打印
    private int state;

    private Lock lock = new ReentrantLock();

    public PrintABCUsingLock(int times) {
        this.times = times;
    }

    private void printLetter(String name, int targetNum) {
        for (int i = 0; i < times; i++) {
            lock.lock();
            if (state % 3 == targetNum) {
                state++;
                i++;
                System.out.println(name);
            }
            lock.unlock();

        }
    }

    public static void main(String[] args) {
        PrintABCUsingLock loopThread = new PrintABCUsingLock(1);

        new Thread(() -> {
            loopThread.printLetter("A", 0);
        }, "A").start();
        new Thread(() -> {
            loopThread.printLetter("B", 1);
        }, "B").start();

        new Thread(() -> {
            loopThread.printLetter("C", 2);
        }, "C").start();
    }
}
