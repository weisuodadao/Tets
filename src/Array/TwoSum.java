package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by luoxianzhuo on 2019/3/30 16:06
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class TwoSum {

    public static List<List<Integer>> twoSum(int[] a, int target) {
        if (a.length == 0) return null;
        int i = 0;
        int j = a.length - 1;
        Arrays.sort(a);
        List<List<Integer>> list = new ArrayList<>();
        while (i < j) {
            int sum = a[i] + a[j];
            if (sum == target) {
                list.add(Arrays.asList(a[i], a[j]));
                i++;
                j--;
            } else if (target > sum) {
                i++;
            } else {
                j--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 1, 2, 3, 6, 7, 8,8, 9, 11, 15,};
        System.out.println(TwoSum.twoSum(a, 9));
    }
}