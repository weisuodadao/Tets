package src.Old.String;

/**
 * @ClassName IndexOf
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/10/28 11:31 上午
 * @Version V1.0
 *
 * 实现 indexOf() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 *
 * 说明：
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。
 *
 * 示例 1：
 *
 * 输入：haystack = “hello”, needle = “ll”
 * 输出：2
 * 示例 2：
 *
 * 输入：haystack = “aaaaa”, needle = “bba”
 * 输出：-1
 * 示例 3：
 *
 * 输入：haystack = “”, needle = “”
 * 输出：0
 *
 **/
public class IndexOf {

    public int indexOf(String src, String pat) {
        int n = src.length();
        int m = pat.length();
        for (int i = 0; i < n - m + 1; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (src.charAt(i + j) != pat.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    int of(String src,String pat){
        int n=src.length();
        int m=pat.length();
        for (int i = 0; i < n-m+1; i++) {
            boolean flag=true;
            for (int j = 0; j < m; j++) {
                if (src.charAt(i+j)!=pat.charAt(j)){
                    flag=false;
                    break;
                }
            }
            if (flag){
                return i;
            }
        }
        return -1;
    }


}
