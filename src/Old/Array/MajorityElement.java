package src.Old.Array;

import java.util.Arrays;

/**
 * @ClassName MajorityElement
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/8/26 7:40 下午
 * @Version V1.0
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 最优解：投票算法
 *
 **/
public class MajorityElement {


    //如果将数组 nums 中的所有元素按照单调递增或单调递减的顺序排序，那么下标为n/2的元素（下标从 0 开始）一定是众数
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
