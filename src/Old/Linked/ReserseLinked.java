package src.Old.Linked;

public class  ReserseLinked {

    public ListNode ReverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

   ListNode re(ListNode l){
        if (l==null)return null;
        ListNode p=null;
        while (l!=null){
            ListNode next=l.next;
            l.next=p;
            p=l;
            l=next;
        }
        return p;
   }

    public ListNode ReverseList(ListNode head) {
        //如果链表为空或者链表中只有一个元素
        if (head == null || head.next == null)
            return head;
        //先反转后面的链表，走到链表的末端结点
        ListNode prev = ReverseList(head.next);
        //再将当前节点设置为后面节点的后续节点
        head.next.next = head;
        head.next = null;
        return prev;
    }
}
