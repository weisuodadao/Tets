package src.Old;

/**
 * Created by luoxianzhuo on 2019/8/1 22:21
 * 二分查找
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class BinarySearch {

    public static int search(int[] a, int target) {
        if (a.length <= 0) return -1;
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (target == a[middle]) {
                return middle;
            } else if (a[middle] > target) {
                end = middle - 1;
            } else if (a[middle] < target) {
                start = middle + 1;
            }
        }
        return -1;
    }
}