package src.Old;

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
            quickSort(arr, pivotLoc + 1, high);
        }
    }

    public void kuaisupaixu(int[] a, int lo, int hi) {
        int p;
        while (lo < hi) {
            p = fengedian(a, lo, hi);
            kuaisupaixu(a, lo, p - 1);
            kuaisupaixu(a, p + 1, hi);
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

    private int fengedian(int[] a, int l, int h) {
        int p = a[l];
        while (l < h) {
            while (l < h && a[h] > p) {
                h--;
            }
            while (l < h && a[l] <p){
                l++;
            }
            a[h] = a[l];
            a[l] = p;
        }
        return l;
    }
}