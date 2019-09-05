package src;

import java.util.HashMap;

/**
 * Created by luoxianzhuo on 2019/3/28 21:55
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class LRUCache {


    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map;
    int cap;
    Node head = null;
    Node tail = null;

    public LRUCache(int capacity) {
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

        return t.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node t = map.get(key);
            t.value = value;

            remove(t);
            setHead(t);
        } else {
            if (map.size() >= cap) {
                map.remove(tail.key);
                remove(tail);
            }

            Node t = new Node(key, value);
            setHead(t);
            map.put(key, t);
        }
    }

    //remove a node
    private void remove(Node t) {
        if (t.prev != null) {
            t.prev.next = t.next;
        } else {
            head = t.next;
        }

        if (t.next != null) {
            t.next.prev = t.prev;
        } else {
            tail = t.prev;
        }
    }

    //set a node to be head
    private void setHead(Node t) {
        if (head != null) {
            head.prev = t;
        }

        t.next = head;
        t.prev = null;
        head = t;

        if (tail == null) {
            tail = head;
        }
    }


}