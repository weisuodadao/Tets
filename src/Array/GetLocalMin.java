package src.Array;

/**
 * Created by luoxianzhuo on 2019/9/17 21:17
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class GetLocalMin {

    public int findLocalMin(int arr[], int l, int r) {
        if (arr[l] < arr[l + 1]) {
            return l;
        }
        if (arr[r - 1] > arr[r]) {
            return r;
        }
        int mid = l + ((l + r) >> 1);
        if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1]) {
            return mid;
        }
        if (arr[mid - 1] < arr[mid]) {
            return findLocalMin(arr, l, mid);
        }
        if (arr[mid] > arr[mid + 1]) {
            return findLocalMin(arr, mid, r);
        }
        return -1;
    }
}