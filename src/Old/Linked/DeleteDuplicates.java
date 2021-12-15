package src.Old.Linked;

/**
 * Created by luoxianzhuo on 2019/9/5 18:33
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 删除链表重复元素，保证链表升序排列
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    ListNode del(ListNode head) {
        ListNode c = head;
        while (c != null && c.next != null) {
            if (c.next.val == c.val) {
                c.next = c.next.next;
            } else {
                c = c.next;
            }
        }
        return head;
    }
}