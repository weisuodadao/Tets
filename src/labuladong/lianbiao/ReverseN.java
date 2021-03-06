package src.labuladong.lianbiao;

/**
 * @ClassName reverseN
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/3/5 6:18 下午
 * @Version V1.0
 *
 * 反转链表前 N 个节点
 **/
public class ReverseN {

    ListNode afterNode = null;

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            afterNode = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);
        // 让反转之后的 head 节点和后面的节点连起来
        head.next.next = head;
        head.next = afterNode;
        return last;
    }


    //反转位置从m到n的链表
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;

    }

}
