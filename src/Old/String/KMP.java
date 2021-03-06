package src.Old.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luoxianzhuo on 2019/4/13 17:07
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class KMP {

    public static List<Integer> kmp(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) return null;
        List<Integer> res = new ArrayList<>();
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int[] next = getNext(p);
        int i = 0, j = 0;
        while (i < sArr.length) {
            while (j < pArr.length) {
                //加判断防止i溢出
                if (i >= sArr.length)
                    break;
                //j为-1或匹配，则两数组往后遍历
                if (j == -1 || sArr[i] == pArr[j]) {
                    i++;
                    j++;
                } else {
                    //匹配失败，在next数组中找到应该移动到的位置
                    j = next[j];
                }
            }
            if (j == pArr.length) {
                res.add(i - j);
                j = 0;
            }
        }

        return res;

    }

    //根据模式串计算next数组, next数组记录如果当前j不匹配应该跳到哪个位置
    private static int[] getNext(String p) {
        char[] pArr = p.toCharArray();
        int[] next = new int[pArr.length];
        //如果第一个都不匹配，标记为-1
        next[0] = -1;
        //k表示j不匹配时的下标值
        int j = 0;
        int k = -1;
        while (j < pArr.length - 1) {
            if (k == -1 || pArr[j] == pArr[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String s = "abcabab";
        String p = "ab";
        List<Integer> res = kmp(s, p);
        for (Integer item : res) {
            System.out.println(item);
        }
    }
}