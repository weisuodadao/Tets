package src.Old.Array;

/**
 * Created by luoxianzhuo on 2019/3/27 17:06
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class ReverseArraysearch {

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (target == nums[start]) {
                return start;
            }
            if (target == nums[end]) {
                return end;
            }

            int middle = (start + end) / 2;
            if (target == nums[middle]) {
                return middle;
            }

            if (nums[start] > nums[middle]) {
                if (target > nums[middle] && nums[start] > target) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }

            } else {
                if (target < nums[middle] && target > nums[start]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
        }

        return -1;
    }

}