package src.Old;

import java.util.HashMap;

/**
 * @ClassName LRU
 * @Description:
 * @Author xianzhuo
 * @Date 2021/11/21 5:27 下午
 * @Version V1.0
 **/
public class LRU {

    class Node {

        int key;
        int val;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, Node> map;
    int cap;
    Node head = null;
    Node tail = null;

    public LRU(int capacity) {
        this.map = new HashMap<>();
        this.cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node t = map.get(key);
        remove(t);
        setHead(t);
        return t.val;
    }

    public void put(int k, int v) {
        if (map.containsKey(k)) {
            Node t = map.get(k);
            t.val = v;
            remove(t);
            setHead(t);
        } else {
            if (map.size() >= cap) {
                map.remove(tail.key);
                remove(tail);
            }
            Node t = new Node(k, v);
            setHead(t);
            map.put(k, t);
        }
    }

    private void remove(Node t) {
        if (t.pre != null) {
            t.pre.next = t.next;
        } else {
            head = t.next;
        }

        if (t.next != null) {
            t.next.pre = t.pre;
        } else {
            tail = t.pre;
        }
    }

    private void setHead(Node t) {
        if (head != null) {
            head.pre = t;
        }
        t.next = head;
        t.pre = null;
        head = t;
        if (tail == null) {
            tail = head;
        }
    }

}
