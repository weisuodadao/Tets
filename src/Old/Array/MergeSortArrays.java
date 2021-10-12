package src.Old.Array;

/**
 * Created by luoxianzhuo on 2019/9/13 15:52
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 合并两个有序数组
 */
public class MergeSortArrays {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }


    public void merge2(int[] a1, int[] a2) {
        int m = a1.length;
        int n = a2.length;
        int p1 = 0, p2 = 0;
        int[] fina = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = a2[p2++];
            } else if (p2 == n) {
                cur = a1[p1++];
            } else if (a1[p1] < a2[p2]) {
                cur = a1[p1++];
            } else {
                cur = a2[p2++];
            }
            fina[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; i++) {
            a1[i] = fina[i];

        }
    }
}