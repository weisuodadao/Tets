package src.Old.Array;

/**
 * @ClassName MaxSubArray
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/7/7 5:31 下午
 * @Version V1.0
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大为 6 。
 *
 * 假设 nums 数组的长度是 nn，下标从 00 到 n-1n−1。
 *
 * 我们用 f(i)代表以第 i 个数结尾的「连续子数组的最大和
 * 只需要求出每个位置的 f(i)f(i)，然后返回 ff 数组中的最大值即可。那么我们如何求 f(i) 呢？我们可以考虑nums[i]单独成为一段还是加入
 * f(i-1)对应的那一段，这取决于 nums[i] 和 f(i-1) + f(i−1)+nums[i] 的大小，我们希望获得一个比较大的，
 * 于是可以写出这样的动态规划转移方程：
 *
 * f(i) = max{f(i-1) + nums[i], nums[i]}
 *
 **/
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums.length < 1) {
            return -1;
        }
        int pre = 0;
        int maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, pre);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }

}
