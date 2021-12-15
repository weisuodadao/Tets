package src.Old.Array;

/**
 * Created by luoxianzhuo on 2019/3/27 17:05
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class ArrayKthLargest {

    public int findKthLargestByQsort(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int findKth(int[]a,int k){
        return quick(a,0,a.length-1,a.length-k);
    }


    public int quickSelect(int[] nums, int left, int right, int kSmallest) {
        if (left == right) {
            return nums[left];
        }
        int pivot_index = partitionLoc(nums, left, right);
        // the pivot is on (N - k)th smallest position
        if (kSmallest == pivot_index) {
            return nums[kSmallest];
        }
        // go left side
        else if (kSmallest < pivot_index) {
            return quickSelect(nums, left, pivot_index - 1, kSmallest);
        }
        // go right side
        return quickSelect(nums, pivot_index + 1, right, kSmallest);
    }

    int quick(int[]a,int left,int right,int kSmall){
        if (left==right)return a[left];
        int pk=partitionLoc(a,left,right);
        if (kSmall==pk)return a[kSmall];
        else if (kSmall<pk){
            return quick(a,left,pk-1,kSmall);
        }
        return quick(a,pk+1,right,kSmall);
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


    //小顶堆做排序
    public int findNumberK(int[] num, int k) {
        //1.用前k个元素构建小顶堆
        buildHeap(num, k);
        //2.继续遍历数组，和堆顶比较
        for (int i = 0; i < num.length; i++) {
            if (num[i] > num[0]) {
                num[0] = num[i];
                downAdjust(num, 0, k);
            }
        }
        //3.返回堆顶元素
        return num[0];
    }

    private void buildHeap(int[] num, int k) {
        //从最后一个非叶子节点开始，依次下沉调整
        for (int i = (k / 2) / 2; i >= 0; i--) {
            downAdjust(num, i, k);
        }
    }

    //下沉调整
    private void downAdjust(int[] num, int index, int length) {
        //temp保存父节点的值，用于最后的赋值
        int temp = num[index];
        int childIndex = 2 * index + 1;
        while ((childIndex < length)) {
            //如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && num[childIndex + 1] < num[childIndex]) {
                childIndex++;
            }
            //如果父节点小于任何一个孩子的值，直接跳出
            if (temp <= num[childIndex]) {
                break;
            }
            //无需真正交换，单项赋值即可
            num[index] = num[childIndex];
            index = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        num[index] = temp;
    }


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
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 11, 12, 7, 8};
        ArrayKthLargest arrayKthLargest = new ArrayKthLargest();
        System.out.println(arrayKthLargest.findKthLargestByQsort(arr, 3));
    }


}