package src.Offer.Array;

/**
 * @ClassName NumWays
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/7/12 4:55 下午
 * @Version V1.0
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 *
 **/
public class NumWays {

    public int numWays(int n) {
        int a = 1;
        int b = 1;
        int sum;
        for (int i = 1; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;

        }
        return a;
    }

}
