package src.Old.Linked;

/**
 * @ClassName MiddleNode
 * @Description:
 * @Author xianzhuo
 * @Date 2021/8/11 3:33 下午
 * @Version V1.0
 *
 * 求单链表的中间节点
 *
 * 快慢指针
 **/
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
