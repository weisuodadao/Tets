package src.Old.Linked;

/**
 * Created by luoxianzhuo on 2019/3/28 21:42
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class AddTwoNumbers {
    /**
     * @author luoxianzhuo
     * @date 2019/3/27 15:39
     * @version V1.0.0
     * @description 链表相加
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            //处理进位问题
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }
}