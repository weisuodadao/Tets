package src.gupiao;

/**
 * @ClassName MaxProfit
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/8/1 6:42 下午
 * @Version V1.0
 *
 * 给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；整数fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出：8
 * 解释：能够达到的最大利润:
 * 在此处买入prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8
 * 定义状态 {dp}[i][0] 表示第 i天交易完后手里没有股票的最大利润，{dp}[i][1] 表示第 i
 * 天交易完后手里持有一支股票的最大利润（i 从 0 开始）。
 *
 * 对于初始状态，根据状态定义我们可以知道第 0天交易结束的时候有 {dp}[0][0]=0 以及 {dp}[0][1]=-{prices}[0]
 *
 *  dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]−fee}
 * dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}
 *
 * 由于全部交易结束后，持有股票的收益一定低于不持有股票的收益，因此这时候 {dp}[n-1][0]的收益必然是大于 {dp}[n-1][1]的，最后的答案即为 {dp}[n-1][0]。
 *
 *注意到在状态转移方程中，dp[i][0] 和 dp[i][1] 只会从dp[i−1][0] 和 dp[i−1][1] 转移而来，
 * 因此我们不必使用数组存储所有的状态，而是使用两个变量 sell 以及 buy 分别表示 dp[..][0] 和dp[..][1] 直接进行状态转移即可。
 *
 *手续费
 **/
public class MaxProfit {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int sell = 0;
        int buy = -prices[0];
        for (int i = 1; i < n; ++i) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }


}
