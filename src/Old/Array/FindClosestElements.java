package src.Old.Array;

import java.util.Collections;
import java.util.List;

/**
 * Created by luoxianzhuo on 2019/3/29 19:33
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class FindClosestElements {

    public class Solution {
        public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
            int n = arr.size();
            if (x <= arr.get(0)) {
                return arr.subList(0, k);
            } else if (arr.get(n - 1) <= x) {
                return arr.subList(n - k, n);
            } else {
                int index = Collections.binarySearch(arr, x);
                if (index < 0) {
                    index = -index - 1;
                }

                int low = Math.max(0, index - k - 1), high = Math.min(arr.size() - 1, index + k - 1);

                while (high - low > k - 1) {
                    if (low < 0 || (x - arr.get(low)) <= (arr.get(high) - x)) {
                        high--;
                    } else if (high > arr.size() - 1 || (x - arr.get(low)) > (arr.get(high) - x)) {
                        low++;
                    }
                }
                return arr.subList(low, high + 1);
            }
        }
    }

}