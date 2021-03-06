package src.Old.Linked;

import java.util.Stack;

/**
 * Created by luoxianzhuo on 2019/9/2 18:28
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class PailLinked {

    //利用栈的思想
    public boolean checkPalindrom(ListNode node) {
        if (node == null)
            return false;
        Stack<ListNode> stack = new Stack<>();
        ListNode fast = node;
        ListNode slow = node;
        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        //如果为奇数个
        if (fast != null)
            slow = slow.next;
        while (!stack.isEmpty()) {
            if (stack.pop().val != slow.val)
                return false;
            slow = slow.next;
        }

        return true;
    }

    //利用链表反转的思想
    public boolean isPalindrome(ListNode head) {
        // 要实现 O(n) 的时间复杂度和 O(1) 的空间复杂度，需要翻转后半部分
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 根据快慢指针，找到链表的中点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow.next);
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        // 递归到最后一个节点，返回新的新的头结点
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }

    private ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode next = null;
        while (head.next != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}