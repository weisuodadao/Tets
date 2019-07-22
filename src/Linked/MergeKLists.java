package src.Linked;

/**
 * Created by luoxianzhuo on 2019/3/27 15:26
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class MergeKLists {

    /**
     * @author luoxianzhuo
     * @date 2019/3/27 15:37
     * @version V1.0.0
     * @description 合并K个排序链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }

    /**
    * @author luoxianzhuo
    * @date 2019/3/28 21:45
    * @version V1.0.0 
    * @description 切分点
    */
    private static ListNode partion(ListNode[] lists, int s, int e) {
        if (s == e) return lists[s];
        if (s < e) {
            int q = (s + e) / 2;
            ListNode l1 = partion(lists, s, q);
            ListNode l2 = partion(lists, q + 1, e);
            return merge(l1, l2);
        } else {
            return null;
        }
    }

    /**
     * @author luoxianzhuo
     * @date 2019/3/27 15:37
     * @version V1.0.0
     * @description 合并有序链表
     */
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }

    }


}