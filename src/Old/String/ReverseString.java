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
        // step 2. 翻转每一个字母
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

    public static void main(String[] args) {
        ReverseString r = new ReverseString();
        System.out.println(r.reverseWords("i am boy"));
    }


}