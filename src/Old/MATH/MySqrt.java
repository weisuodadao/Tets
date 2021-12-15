package src.Old.MATH;

/**
 * @ClassName MySqrt
 * @Description:
 * @Author xianzhuo
 * @Date 2021/9/5 5:46 下午
 * @Version V1.0
 *
 * 实现int sqrt(int x)函数。
 *
 * 计算并返回x的平方根，其中x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 输入: 4
 * 输出: 2
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 **/
public class MySqrt {


    //二分法
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;

    }

}
