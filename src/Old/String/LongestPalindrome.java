package src.Old.String;

/**
 * Created by luoxianzhuo on 2019/4/9 19:01
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 最长回文无重复子串
 */
public class LongestPalindrome {



    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //奇数长度
            int len1 = expandAroundCenter(s, i, i);
            //偶数长度
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        //这里的end+1是因为 java自带的左闭右开的原因
        return s.substring(start, end + 1);
    }

    /**
     * @author luoxianzhuo
     * @date 2019/9/5 22:21
     * @version V1.0.0
     * @description 字符串周围长度
     */
    private int expandAroundCenter(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        // 跳出循环的时候恰好满足 s.charAt(left) ！= s.charAt(right)
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 回文串的长度是right-left+1-2 = right - left - 1
        return right - left - 1;
    }

}