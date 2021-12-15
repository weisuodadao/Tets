package src.Old.Array;

import java.util.List;

/**
 * @ClassName MinimumTotal
 * @Description:
 * @Author xianzhuo
 * @Date 2021/6/27 4:54 下午
 * @Version V1.0
 *
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）
 *
 *
 * 输入：triangle = [[-10]]
 * 输出：-10

 *定义二维 dp 数组，将「自顶向下的递归」改为「自底向上的递推」。
 * dp[i][j] 表示从点 (i, j)(i,j) 到底边的最小路径和。
 * dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
 * 实际递推中我们发现，计算 dp[i][j]时，只用到了下一行的 dp[i + 1][j]和 dp[i + 1][j + 1]
 * 因此dp数组不需要定义 N行，只要定义1行就阔以啦。
 *
 **/
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j] + triangle.get(i).get(j));
            }
        }
        return dp[0];

    }

}
