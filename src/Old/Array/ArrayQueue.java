package src.Old.Array;

/**
 * Created by luoxianzhuo on 2019/4/9 21:47
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class  ArrayQueue {

    private int[] arrInt;// 内置数组
    private int front;// 头指针
    private int rear;// 尾指针

    public ArrayQueue(int size) {
        this.arrInt = new int[size];
        front = 0;
        rear = -1;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == arrInt.length;
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return arrInt.length - 1 == rear;
    }

    /**
     * 向队列的队尾插入一个元素
     */
    public void insert(int item) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        arrInt[++rear] = item;
    }

    /**
     * 获得队头元素
     *
     * @return
     */
    public int peekFront() {
        return arrInt[front];
    }

    /**
     * 获得队尾元素
     *
     * @return
     */
    public int peekRear() {
        return arrInt[rear];
    }

    /**
     * 从队列的对头移除一个元素
     *
     * @return
     */
    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arrInt[front++];
    }
}