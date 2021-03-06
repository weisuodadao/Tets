package src.Old.与;

/**
 * Created by luoxianzhuo on 2019/3/28 20:00
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 对于数字 6(110)，它可以看成是 4(100) 再加一个 2(10)，因此 dp[i] = dp[i&(i-1)] + 1;
 */
public class countBits {

    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        for(int i = 1; i <= num; i++){
            ret[i] = ret[i&(i-1)] + 1;
        }
        return ret;
    }

}