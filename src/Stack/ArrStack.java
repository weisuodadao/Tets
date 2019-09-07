package src.Stack;

/**
 * Created by luoxianzhuo on 2019/3/18 20:49
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class ArrStack {

    private int[] a = new int[1];

    private int N = 0;


    public void push(int x) {
        check();
        a[N++] = x;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("stack is empty");
        }

        int popNum = a[--N];
        check();
        return popNum;

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("stack is empty");
        }
        return a[N - 1];
    }

    private void check() {
        if (N >= a.length) {
            resize(2 * a.length);
        } else if (N > 0 && N <= a.length / 4) {
            resize(a.length / 2);
        }
    }

    private void resize(int size) {
        int[] tmp = new int[size];
        for (int i = 0; i < N; i++) {
            tmp[i] = a[i];
        }
        a = tmp;
    }

    public static void main(String[] args) throws Exception {
        ArrStack m=new ArrStack();
        m.push(1);
        System.out.println(m.peek());
    }
}