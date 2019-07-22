package src.String;

/**
 * Created by luoxianzhuo on 2019/4/11 21:14
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String str = "";
        if (strs.length > 0) {
            str = strs[0];
            for (int i = 1; i < strs.length; i++) {
                while (!strs[i].startsWith(str)) {
                    if (str.length() > 1) {
                        str = str.substring(0, str.length() - 1);
                    } else {
                        return "";
                    }
                }

            }
        }
        return str;
    }

}