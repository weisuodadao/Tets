package src.Old.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Permute
 * @Description: 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @Author xianzhuo
 * @Date 2021/6/20 6:49 下午
 * @Version V1.0
 **/
public class Permute {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int n : nums) {
            output.add(n);
        }
        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;

    }

    private void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i <n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 回溯撤销操作
            Collections.swap(output, first, i);
        }
    }

}
