package src.Offer.Array;

/**
 * @ClassName SingleNumber3
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/7/5 4:54 下午
 * @Version V1.0
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 、输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 * 异或:x ^ 0 = x ， x ^ 1 = ~x
 * 与：x & 0 = 0,x & 1 = x
 *
 * if two == 0:
 *   if n == 0:
 *     one = one
 *   if n == 1:
 *     one = ~one
 * if two == 1:
 *     one = 0
 *
 *引入 异或运算 ，可将以上拆分简化为：
 * if two == 0:
 *     one = one ^ n
 * if two == 1:
 *     one = 0
 *
 *引入 与运算 ，可继续简化为：
 *     one = one ^ n & ~two
 **/
public class SingleNumber3 {

    public int singleNumber(int[] nums) {
        if (nums.length < 1) {
            return -1;
        }
        int one = 0;
        int two = 0;
        for (int i : nums) {
            one = one ^ i & ~two;
            two = two ^ i & ~one;

        }
        return one;

    }

}
