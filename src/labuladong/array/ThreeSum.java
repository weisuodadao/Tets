package src.labuladong.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName ThreeSum
 * @Description:
 * @Author xianzhuo
 * @Date 2021/3/30 4:29 下午
 * @Version V1.0
 **/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 1) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1;
                int hi = nums.length - 1;
                int sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi] == nums[hi - 1]) {
                            hi--;

                        }
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else if (nums[lo] + nums[hi] > sum) {
                        hi--;
                    }
                }

            }

        }
        return res;
    }

}
