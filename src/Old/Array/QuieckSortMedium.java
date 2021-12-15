package src.Old.Array;

/**
 * Created by luoxianzhuo on 2019/3/24 16:54
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 数组中值
 */
public class QuieckSortMedium {

    public static int getMedian(int[] nums) {
        return partition(nums, 0, nums.length - 1);
    }

    private static int partition(int[] nums, int start, int end) {
        /***快排partition函数原代码——start***/
        int left = start;
        int right = end;

        int point = nums[start];
        while (true) {
            while (left < right && nums[right] >= point) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= point) {
                left++;
            }
            nums[right] = nums[left];
            if (left == right) {
                break;
            }
        }
        nums[left] = point;
        /***快排partition函数原代码——end***/

        /***定位判断***/
        if (left == (nums.length - 1) / 2) {
            return nums[left];
        } else if (left > (nums.length - 1) / 2) {
            return partition(nums, start, left - 1);
        } else {
            return partition(nums, left + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 11, 12, 7, 8};
        System.out.println(QuieckSortMedium.getMedian(arr));
    }
}