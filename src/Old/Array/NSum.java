package src.Old.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by luoxianzhuo on 2019/3/27 16:08
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class NSum {

    /**
     * @author luoxianzhuo
     * @date 2019/3/27 16:09
     * @version V1.0.0
     * @description 三数之和
     */
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        //注意减2
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1;
                int hi = num.length - 1;
                int sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && num[hi] == num[hi - 1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> sum3(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < a.length - 2; i++) {
            int l = i + 1;
            int h = a.length - 1;
            int sum = 0 - a[i];
            while (l < h) {
                if (sum == a[l] + a[h]) {
                    list.add(Arrays.asList(a[l], a[h]));
                    while (l < h && a[l] == a[l + 1]) {
                        l++;
                    }
                    while ((l < h) && a[h] == a[h - 1]) {
                        h--;
                    }
                    l++;
                    h--;
                } else if (a[l] + a[h] < sum) {
                    l++;
                } else {
                    h--;
                }
            }


        }
        return list;
    }

}