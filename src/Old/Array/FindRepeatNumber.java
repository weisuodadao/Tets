package src.Old.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName FindRepeatNumber
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/7/5 4:48 下午
 * @Version V1.0
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 **/
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        if (nums.length < 1) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        int reaPeat = -1;
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                reaPeat = nums[i];
            }

        }
        return reaPeat;
    }


}
