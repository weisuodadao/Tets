package src.Old.DP;

/**
 * Created by luoxianzhuo on 2019/3/28 20:12
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 爬楼梯
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int pre = 1, next = 2;
        for (int i = 2; i < n; i++) {
            int cur = pre + next;
            pre = next;
            next = cur;
        }
        return next;
    }

}