package src;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by luoxianzhuo on 2019/4/10 21:10
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class TestAnt {

    public int findKthLargest(int[] a, int k) {

        return findK(a, 0, a.length - 1, a.length - k);
    }

    private Object[] removeDuplicate(int[] a){
        Set set = new HashSet();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        return set.toArray();
    }


    /**
    * @author luoxianzhuo
    * @date 2019/4/10 21:33
    * @version V1.0.0 
    * @description 求出 
    */
    private int findK( int[]a,int start, int end, int k) {
        if (start == end) {
            return a[start];
        }
        int pivot = a[(start + end) / 2];
        int i = start;
        int j = end;
        while (i <= j) {
            while (a[i] < pivot) {
                i++;
            }

            while (a[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }
        if (k >= (i - start)) {
            return findK(a, i, end, k - i + start);
        } else {
            return findK(a, start, i - 1, k);
        }
        
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}