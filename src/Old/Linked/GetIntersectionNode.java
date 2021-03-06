package src.Old.Linked;

/**
 * Created by luoxianzhuo on 2019/3/28 21:42
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class GetIntersectionNode {

    /**
     * @author luoxianzhuo
     * @date 2019/3/27 15:27
     * @version V1.0.0
     * @description 相交链表找相交节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;

    }
}