package src.Old;

import java.util.HashMap;

/**
 * Created by luoxianzhuo on 2019/3/15 17:05
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class LRUCache1 {

    class Node {
        int val;
        int key;
        Node pre;
        Node next;

        public Node(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }

    int capacity;
    HashMap<Integer, Node> Map = new HashMap<>();
    Node head = null;
    Node end = null;


    public LRUCache1(int capacity) {
        capacity = capacity;
        head.next = end;
        end.pre = head;
    }

    public int get(int key) {
        if (Map.containsKey(key)) {
            Node n = Map.get(key);
            remove(n);
            setHead(n);
            return n.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (Map.containsKey(key)) {
            Node old = Map.get(key);
            old.val = value;
            remove(old);
            setHead(old);

        } else {
            Node created = new Node(key, value);
            if (Map.size() >= capacity) {
                Map.remove(end.key);
                remove(end);
                setHead(created);
            } else {
                setHead(created);
            }
            Map.put(key, created);

        }

    }

    private void remove(Node n) {
        if (n.pre != null) {
            n.pre.next = n.next;

        } else {
            head = n.next;
        }
        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }
    }

    private void setHead(Node n) {
        n.next = head;
        n.pre = null;
        if (head != null) {
            head.pre = n;
        }
        head = n;
        if (end == null) {
            end = head;
        }
    }

}