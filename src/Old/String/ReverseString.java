package src.Old.String;

/**
 * Created by luoxianzhuo on 2019/3/27 16:13
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class ReverseString {

    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. 翻转整个字符串
        reverse(a, 0, n - 1);
        // step 2. 翻转每一个字母回来
        reverseWords(a, n);
        // step 3.去除空格
        return cleanSpaces(a, n);
    }


    // reverse a[] from a[i] to a[j]
    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }

    private void reverseWords(char[] a, int n) {
        int i = 0, j = 0;
        while (i < n) {
            // 跳空格
            while (i < j || i < n && a[i] == ' ') {
                i++;
            }
            // skip non spaces
            while (j < i || j < n && a[j] != ' ') {
                j++;
            }
            reverse(a, i, j - 1); // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    private String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && a[j] == ' ') {
                j++;             // skip spaces
            }
            while (j < n && a[j] != ' ') {
                a[i++] = a[j++]; // keep non spaces
            }
            while (j < n && a[j] == ' ') {
                j++;             // skip spaces
            }
            if (j < n) {
                a[i++] = ' ';                      // keep only one space
            }
        }

        return new String(a).substring(0, i);
    }


    String reString(String s) {
        if (s == null) {
            return null;
        }
        //去空格
        StringBuilder sb = trimSpace(s);
        //翻转
        reverse1(sb, 0, sb.length() - 1);
        //翻转每个单词
        reWord(sb);
        return sb.toString();
    }

    private StringBuilder trimSpace(String s) {
        int left = 0, right = s.length() - 1;
        //去除开头空格
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        //去除末尾空格
        while (left < right && s.charAt(right) == ' ') {
            right--;
        }
        //字符间距多余空格
        StringBuilder sb = new StringBuilder();
        while (left < right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            left++;
        }
        return sb;
    }

    void reverse1(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    void reWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverse1(sb, start, end - 1);
            start = end + 1;
            end++;
        }
    }

    public static void main(String[] args) {
        ReverseString r = new ReverseString();
        System.out.println(r.reverseWords("i am boy"));
    }


}