package src.Old.String;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by luoxianzhuo on 2019/3/26 22:07
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 最长无重复子串长度
 */
public class LengthOfLongestSubstring {


    /**
     * @Author luoxianzhuo
     * @Description 滑动窗口解法
     * @Date 2021/8/8 9:33 下午
     * @Param
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                rk++;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return 0;
    }

    /**
     * @author luoxianzhuo
     * @date 2019/3/27 17:22
     * @version V1.0.0
     * @description 子串
     */
    public String lengthOfLongestSubstring2(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int index = 0;
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                int k = ans;
                ans = Math.max(ans, j - i);
                if (k != ans) {
                    index = i;
                }
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return s.substring(index, index + ans);
    }

    /**
     * @author luoxianzhuo
     * @date 2019/3/27 17:22
     * @version V1.0.0
     * @description 子串长度
     */
    public int lengthOfLongestSubstring4(String s) {
        int[] hash = new int[256];
        int max = 0;
        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (hash[s.charAt(j)] == 0) {
                hash[s.charAt(j)] = 1;
                j++;
                max = Math.max(j - i, max);
            } else {
                hash[s.charAt(i)] = 0;
                i++;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring4("sadnbasnmfabdnjashdjh"));
    }
}