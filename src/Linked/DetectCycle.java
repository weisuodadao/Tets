package src.Linked;

/**
 * Created by luoxianzhuo on 2019/3/28 21:43
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class DetectCycle {

    /**
     * @author luoxianzhuo
     * @date 2019/3/27 17:18
     * @version V1.0.0
     * @description 环形链表
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        while (head != null && slow != null) {
            if (head == slow) {
                return slow;
            }
            head = head.next;
            slow = slow.next;
        }
        return null;
    }
}