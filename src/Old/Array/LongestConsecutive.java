package src.Old.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LongestConsecutive
 * @Description:
 * @Author xianzhuo
 * @Date 2021/7/1 4:48 下午
 * @Version V1.0
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 进阶：你可以设计并实现时间复杂度为O(n) 的解决方案吗？
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 如果已知有一个 x+1,x+2,⋯,x+y的连续序列，而我们却重新从 x+1，x+2 或者是 x+y处开始尝试匹配，那么得到的结果肯定不会优于枚举 x为起点的答案，
 * 因此我们在外层循环的时候碰到这种情况跳过即可。
 *
 * 那么怎么判断是否跳过呢？由于我们要枚举的数 x 一定是在数组中不存在前驱数 x-1的，不然按照上面的分析我们会从 x-1开始尝试匹配，
 * 因此我们每次在哈希表中检查是否存在 x-1 即能判断是否需要跳过了。
 *
 **/
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int i : nums) {
            numSet.add(i);
        }
        int longestStreak = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum = currentNum + 1;
                    currentStreak = currentStreak + 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }

        }
        return longestStreak;

    }

}
