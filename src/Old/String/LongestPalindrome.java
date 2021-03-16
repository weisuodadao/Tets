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
        if (s == null || s.length() < 1) return "";
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
        return s.substring(start, end + 1);
    }

    /**
    * @author luoxianzhuo
    * @date 2019/9/5 22:21
    * @version V1.0.0 
    * @description 字符串周围长度 
    */
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}