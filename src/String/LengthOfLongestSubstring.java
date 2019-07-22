package src.String;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by luoxianzhuo on 2019/3/26 22:07
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 最长回文无重复子串
 */
public class LengthOfLongestSubstring {

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

    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0)
            return 0;
        HashSet<Character> set = new HashSet<>();
        int maxLen = 1;
        int i = 0;
        int j = 0;
        for (i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                if (maxLen < i - j)
                    maxLen = i - j;
                while (j < i) {
                    if (s.charAt(j) == s.charAt(i)) {
                        j++;
                        break;
                    }
                    set.remove(s.charAt(j));
                    j++;
                }
            } else {
                set.add(s.charAt(i));
            }
        }
        return Math.max(maxLen, i - j);
    }


    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring4("sadnbasnmfabdnjashdjh"));
    }
}