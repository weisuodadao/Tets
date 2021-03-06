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
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
        while ((p1 >= 0) && (p2 >= 0)){
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1


        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}