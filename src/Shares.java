package src;

/**
 * Created by luoxianzhuo on 2019/3/27 16:11
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class Shares {

    /**
    * @author luoxianzhuo
    * @date 2019/3/27 16:12
    * @version V1.0.0 
    * @description 买卖股票的最佳时机1
    */
    public int maxProfit(int[] prices) {
        int res = 0, buy = Integer.MAX_VALUE;
        for (int price : prices) {
            buy = Math.min(buy, price);
            res = Math.max(res, price - buy);
        }
        return res;

    }
}