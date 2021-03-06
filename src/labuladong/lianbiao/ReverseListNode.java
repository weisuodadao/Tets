package src.labuladong.lianbiao;

/**
 * @ClassName ReverseListNode
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/3/5 6:15 下午
 * @Version V1.0
 **/
public class ReverseListNode {

    //递归
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}
