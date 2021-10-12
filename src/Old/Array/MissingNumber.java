package src.Old.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName MissingNumber
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/8/29 4:44 下午
 * @Version V1.0
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 **/
public class MissingNumber {

    //如果数组是有序的，那么就很容易知道缺失的数字是哪个了。先排序，再遍历判断

    //hashset
    public int missingNumberHash(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }


    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }


}
