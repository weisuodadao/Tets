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
        if (a.length <= 0) {
            return -1;
        }
        int min = 0;
        int max = a.length - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (target == a[mid]) {
                return mid;
            } else if (a[mid] > target) {
                max = mid - 1;
            } else if (a[mid] < target) {
                min = mid + 1;
            }
        }
        return -1;
    }
}