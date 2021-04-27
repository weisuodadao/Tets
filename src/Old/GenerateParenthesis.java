package src.Old;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luoxianzhuo on 2019/9/13 15:09
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 括号生成
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    public void backtrack(List<String> res, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            res.add(cur);
            return;
        }
        if (open < max) {
            backtrack(res, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(res, cur + ")", open, close + 1, max);
        }
    }

}