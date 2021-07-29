package src.Offer.Array;

/**
 * @ClassName CuttingRope
 * @Description:
 * @Author xianzhuo
 * @Date 2021/7/5 5:33 下午
 * @Version V1.0
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
题目要求n大于2，因为长度为1的绳子没法剪，
长度为2的绳子只能剪成两段长度为1的绳子，不能选择不裁剪，因此f[2] = 1；
但长度为2的绳子作为子段再进行裁剪时可以选择不裁剪，此时f[2]就等于2

f[n] = max(f[n-i]*f[i])，i属于[1,n-1]
因此我们在迭代计算每次f[i]的时候要考虑i-1长度的绳子不裁剪的情况。
 **/
public class CuttingRope {

    public int cuttingRope(int n) {
        int[] f = new int[n + 1];
        //f[n]表示长度为n的绳子剪出来的最大面积；
        //f[n] = max(f[n-i]*f[i]);i的范围是1～n-1;
        f[1] = 1;     //补充定义

        //遍历计算f[i]。
        for (int i = 2; i <= n; i++) {
            //考虑长度为i-1的绳子不进行裁剪的情况
            f[i - 1] = Math.max(f[i - 1], i - 1);
            //考虑第一刀应该剪多长
            for (int j = 1; j < i; j++) {
                //比较所有剪法里面的面积最大值
                f[i] = Math.max(f[i], f[i - j] * f[j]);
            }
        }
        return f[n];

    }

}
