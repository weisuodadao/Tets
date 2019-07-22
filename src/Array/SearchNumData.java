package Array;

import java.util.Arrays;

/**
 * Created by luoxianzhuo on 2019/4/10 21:27
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class SearchNumData {

    /**
     * @author luoxianzhuo
     * @date 2019/4/11 19:36
     * @version V1.0.0
     * @description 找到除第k大以外的中位数
     */
    public static int findMediumOutOfKth(int[] nums, int k) {
        int kIndex = findKthLargestIndex(nums, k);
        if (kIndex < 0) {
            return -1;
        }
        return nums[kIndex / 2];
    }

    /**
     * @author luoxianzhuo
     * @date 2019/4/11 19:40
     * @version V1.0.0
     * @description 找到第k大数
     */
    public static int findKthLargest(int[] nums, int k) {
        int largest = findKthLargestIndex(nums, k);
        if (largest < 0) {
            return -1;
        }
        return nums[largest];
    }

    /**
     * @author luoxianzhuo
     * @date 2019/4/11 19:43
     * @version V1.0.0
     * @description 找到第k大索引，不存在返回-1
     */
    private static int findKthLargestIndex(int[] nums, int k) {
        if (nums.length == 0) return -1;
        if (k < 1 || k > nums.length) return -1;
        Arrays.sort(nums);
        int n = nums.length - 1;
        int i = n, count = 0;
        if (nums[0] == nums[n]) {
            return 0;
        }
        while (i > 1 && count != k) {
            i--;
            if (nums[i] != nums[i - 1]) {
                count++;
            }

        }
        return i;
    }

    public static void main(String[] args) {
        //无序多个重复数据
        int[] array = {
                1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 11, 12, 7, 8
        };
        //有序重复数据
        int[] array1 = {
                1, 2, 3, 4, 5, 6, 6
        };
        //全是重复数据
        int[] array2 = {
                1, 1, 1, 1, 1, 1, 1
        };
        //无重复数据
        int[] array3 = {
                1, 2, 3, 4, 5, 6, 66
        };
        System.out.print(findKthLargest(array, 0) + "\n");
        System.out.print(findMediumOutOfKth(array1, 3) + "\n");
        System.out.print(findMediumOutOfKth(array2, 3) + "\n");
        System.out.print(findMediumOutOfKth(array3, 3) + "\n");


    }


}