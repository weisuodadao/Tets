package src.Old.String;

/**
 * Created by luoxianzhuo on 2019/9/11 20:17
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 读入一个字符串str，输出字符串str中的连续最长的数字串
 */
public class Continumax {

    //asci码
    public static String longestNumString(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        int max = 0, count = 0, end = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                count++;
                if (max < count) {
                    max = count;
                    end = i;
                }
            } else {
                count = 0;
            }
        }
        return str.substring(end - max + 1, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestNumString("abcd12345ed125ss123456789"));
    }
}