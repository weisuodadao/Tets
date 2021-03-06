package src.Old;

/**
 * Created by luoxianzhuo on 2019/4/10 21:02
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class Knapsack {


    /**
     * @author luoxianzhuo
     * @date 2019/4/10 21:02
     * @version V1.0.0
     * @description 背包最多能装W磅东西 最多能装N个物品 用dp[i][j]来表示前i件物品体积不超过j的情况下能达到的最大价值
     * 得到公式 dp[i, j] = max{ dp[i-1, j], dp[i-1, j-weights[i-1]] + values[i-1] }
     */
    public int knapsack(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = 1; j <= W; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }


}