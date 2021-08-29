package src.Old.Linked;

/**
 * @ClassName ReverseBetween
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/8/29 3:41 下午
 * @Version V1.0
 *
 *
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 **/
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        // 初始化指针
        ListNode pre = dummyNode;

        //先走到左边
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;

        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;

        }
        return dummyNode.next;

    }


}
