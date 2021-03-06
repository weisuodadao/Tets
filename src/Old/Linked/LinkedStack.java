package src.Old.Linked;

/**
 * Created by luoxianzhuo on 2019/3/18 21:15
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class LinkedStack {

    private ListNode top = null;
    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(int x) {
        ListNode newTop = new ListNode();
        newTop.val = x;
        newTop.next = top;
        top = newTop;
        N++;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("stack is empty");
        }
        int popNum = top.val;
        top = top.next;
        N--;
        return popNum;
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("stack is empty");
        }
        return top.val;
    }

}