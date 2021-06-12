package src.Old.Linked;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by luoxianzhuo on 2019/9/12 16:23
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置
 */
public class PartitionListNode {


        public ListNode partition(ListNode head, int x) {
            ListNode small = new ListNode(0);
            ListNode smallHead = small;
            ListNode large = new ListNode(0);
            ListNode largeHead = large;
            while (head != null) {
                if (head.val < x) {
                    small.next = head;
                    small = small.next;
                } else {
                    large.next = head;
                    large = large.next;
                }
                head = head.next;
            }
            large.next = null;
            small.next = largeHead.next;
            return smallHead.next;
        }


    public ListNode partition2(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }

            head = head.next;
        }

        after.next = null;

        before.next = afterHead.next;
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();

        return beforeHead.next;
    }

}