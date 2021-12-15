package src.Old.Array;

import java.util.Arrays;

/**
 * @ClassName CountPrimes
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/8/29 4:48 下午
 * @Version V1.0
 *
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 **/
public class CountPrimes {

    //埃氏筛
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

}
