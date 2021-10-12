package src.Old.Array;

/**
 * Created by luoxianzhuo on 2019/3/27 17:06
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 搜索旋转排序数组
 */
public class ReverseArraysearch {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
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
                //正常不旋转了
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

    public int find(int[] a, int x) {
        int start = 0, end = a.length - 1;
        while (start < end) {
            if (x == a[start]) {
                return start;
            }
            if (x == a[end]) {
                return end;
            }
            int mid = (start + end) >> 1;
            if (x == a[mid]) {
                return mid;
            }
            if (a[start] > a[mid]) {
                if (x > a[mid] && a[start] > x) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (x < a[mid] && a[start] < x) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }
        }
    }

}