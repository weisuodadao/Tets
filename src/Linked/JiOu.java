package src.Linked;

/**
 * Created by luoxianzhuo on 2019/9/2 17:44
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class JiOu {

    //奇偶节点排序
    ListNode oddEvenList(ListNode head) {
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
        }
        odd.next = evenHead;
        return head;
    }
}