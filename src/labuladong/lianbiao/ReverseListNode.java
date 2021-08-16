package src.labuladong.lianbiao;

/**
 * @ClassName ReverseListNode
 * @Description:
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

    //迭代
    public ListNode reverse2(ListNode head) {
        ListNode pre, cur, next;
        pre = null;
        cur = head;
        while (cur != null) {
            next = cur.next;
            // 逐个结点grid
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = next;
        }
        return pre;

    }

    ///** grid区间 [a, b) 的元素，注意是左闭右开 */
    public ListNode reverse3(ListNode a, ListNode b) {
        ListNode pre, cur, next;
        pre = null;
        cur = a;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    //K 个一组grid链表
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode a, b;
        a = b = head;

        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) {
                return head;
            }
            b = b.next;
        }

        // 反转前 k 个元素
        ListNode newHead = reverse3(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

}
