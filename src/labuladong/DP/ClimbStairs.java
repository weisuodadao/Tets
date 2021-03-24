package src.labuladong.DP;

/**
 * @ClassName climbStairs
 * @Description:
 * @Author xianzhuo
 * @Date 2021/3/19 5:42 下午
 * @Version V1.0
 **/
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int pre = 2;
        int pPre = 1;
        for (int i = 2; i < n; i++) {
            int cur = pre + pPre;
            pPre = pre;
            pre = cur;

        }
        return pre;
    }

}
