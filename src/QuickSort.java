package src;

/**
 * Created by luoxianzhuo on 2019/8/1 22:10
 *快速排序
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        int pivotLoc;
        if (low < high) {
            pivotLoc = partitionLoc(arr, low, high);
            quickSort(arr, low, pivotLoc - 1);
            quickSort(arr, low, high);
        }

    }
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
}