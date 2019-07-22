package src.Linked;

/**
 * Created by luoxianzhuo on 2019/3/19 14:05
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class LinkedQueue {

    private ListNode first;
    private ListNode last;

    int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(int x) {
        ListNode newListNode = new ListNode();
        newListNode.val = x;
        newListNode.next = null;

        if (isEmpty()) {
            last = newListNode;
            first = newListNode;
        } else {
            last.next = newListNode;
            last = newListNode;
        }
        N++;
    }

    public void remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("stack is empty");
        }
        ListNode listNode = first;
        first = first.next;
        N--;
        if (isEmpty()) {
            last = null;
        }
    }
}