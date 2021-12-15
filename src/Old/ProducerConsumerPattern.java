package src.Old;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by luoxianzhuo on 2019/9/3 21:10
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class ProducerConsumerPattern {
    public static void main(String[] args) {
        BlockingQueue sharedQueue = new LinkedBlockingQueue();
        Thread prodThread = new Thread(new Producer(sharedQueue));
        Thread consThread = new Thread(new Consumer(sharedQueue));
        prodThread.start();
        consThread.start();

    }


    static class Producer implements Runnable {
        private final BlockingQueue sharedQueue;

        Producer(BlockingQueue sharedQueue) {
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("producerd" + i);
                try {
                    sharedQueue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    static class Consumer implements Runnable {
        private final BlockingQueue sharedQueue;

        Consumer(BlockingQueue sharedQueue) {
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("consumer:" + sharedQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}