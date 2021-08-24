package src.Old.Linked;

/**
 * @ClassName DeleteNode
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/8/21 3:24 下午
 * @Version V1.0
 **/
public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        return head;
    }

}
