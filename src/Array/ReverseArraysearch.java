package Array;

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


    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int low = 0;
        int high = array.length - 1;
        int mid = low;
        while (array[low] >= array[high]) {
            if (array[low] == array[high]) {
                for (int i = low; i < array.length; i++) {
                    if (array[low] != array[i]) {
                        low = i - 1;
                        break;
                    }
                }
                for (int i = high; i >= 0; i--) {
                    if (array[high] != array[i]) {
                        high = i + 1;
                        break;
                    }
                }
            }
            if (high - low <= 1) {
                mid = high;
                break;
            }
            mid = (low + high) / 2;
            if (array[mid] >= array[low]) {
                low = mid;
            } else if (array[mid] <= array[high]) {
                high = mid;
            }
        }
        return array[mid];
    }
}