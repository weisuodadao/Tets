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
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

   ListNode xiangjiao(ListNode l1,ListNode l2){
        if (l1==null||l2==null){
            return null;
        }
        ListNode a=l1;
        ListNode b=l2;
        while (a!=b){
            a=a==null?l2:a.next;
            b=b==null?l1:b.next;
        }
        return a;
   }
}