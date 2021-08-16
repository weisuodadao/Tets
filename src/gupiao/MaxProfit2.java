package src.gupiao;

/**
 * @ClassName MaxProfit2
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/8/2 5:25 下午
 * @Version V1.0
 *
 * 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * max(f[n−1][0],f[n−1][1],f[n−1][2])
 * max(f[n−1][1],f[n−1][2])
 *
 * 买前必须卖出股票
 **/
public class MaxProfit2 {

    public int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 1; i < prices.length; i++) {
            int newF0 = Math.max(f0, f0 - prices[i]);
            int newF1 = f0 + prices[i];
            int newF2 = Math.max(f1, f2);
            f0 = newF0;
            f1 = newF1;
            f2 = newF2;

        }
        return Math.max(f1, f2);
    }

}
