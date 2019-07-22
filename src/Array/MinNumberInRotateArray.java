package Array;

/**
 * Created by luoxianzhuo on 2019/3/28 21:05
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class MinNumberInRotateArray {

    public static int minNumberInRotateArray(int[] nums) {
        if (nums.length == 0) return 0;
        int low = 0, high = nums.length - 1;
        while (low < high) {

            int middle = low + (high - low) / 2;

            if (nums[low] == nums[middle] && nums[middle] == nums[high]) {
                return minNumber(nums, low, high);
            } else if (nums[middle] <= nums[high]) {
                high = middle;
            } else {
                low = middle + 1;
            }

        }
        return nums[low];
    }

    private static int minNumber(int[] nums, int low, int high) {
        for (int i = low; i < high; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] a= {3, 4, 5, 1, 2};
        System.out.println(MinNumberInRotateArray.minNumberInRotateArray(a));
    }

}