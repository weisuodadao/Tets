package src.Old.Array;

/**
 * Created by luoxianzhuo on 2019/3/27 17:05
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class ArrayKthLargest {

    public int findKthLargest(int[] nums, int k) {
        return findK(nums, 0, nums.length - 1, nums.length - k);
    }

    private int findK(int[] nums, int start, int end, int k) {

        if (start == end) {
            return nums[start];
        }
        int pivot = nums[(start + end) / 2];
        int i = start;
        int j = end;
        while (i <= j) {
            while (nums[i] < pivot) {
                i++;
            }

            while (nums[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        if (k >= (i - start)) {
            return findK(nums, i, end, k - i + start);
        } else {
            return findK(nums, start, i - 1, k);
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 11, 12, 7, 8};
        ArrayKthLargest arrayKthLargest = new ArrayKthLargest();
        System.out.println(arrayKthLargest.findKthLargestByQsort(arr, 3));
    }

    /**
     * @author luoxianzhuo
     * @date 2019/9/16 22:02
     * @version V1.0.0
     * @description 快速排序解法
     */
    private static int partitionLoc(int[] arr, int low, int high) {
        int pivotKey = arr[low];
        while (low < high) {
            while (low < high && arr[high] > pivotKey) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] < pivotKey) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivotKey;
        return low;
    }


    public int quickSelect(int[] nums, int left, int right, int k_smallest) {
    /*
    Returns the k-th smallest element of list within left..right.
    */

        if (left == right) // If the list contains only one element,
            return nums[left];  // return that element

        int pivot_index = partitionLoc(nums, left, right);

        // the pivot is on (N - k)th smallest position
        if (k_smallest == pivot_index)
            return nums[k_smallest];
            // go left side
        else if (k_smallest < pivot_index)
            return quickSelect(nums, left, pivot_index - 1, k_smallest);
        // go right side
        return quickSelect(nums, pivot_index + 1, right, k_smallest);
    }

    public int findKthLargestByQsort(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }


}