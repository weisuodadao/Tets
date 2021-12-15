package src.Old.Linked;

/**
 * @ClassName ReorderList
 * @Description:
 * @Author xianzhuo
 * @Date 2021/9/5 5:17 下午
 * @Version V1.0
 *
 * 重排链表
 * 输入: head = [1,2,3,4]
 * 输出: [1,4,2,3]
 *
 *
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,5,2,4,3]
 **/
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        //求链表中点
        ListNode mid = middleNode(head);

        //反转后半部分链表
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);

        //合并链表
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}

