package src.Old.String;

/**
 * Created by luoxianzhuo on 2019/4/18 21:06
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 同构字符串判断
 * abb和egg title和paper是同构字符串，foo和bar就不是同构字符串
 */
public class IsIsomorphic {

    public boolean isIsomorphic(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i) + 256]) {
                return false;
            }
            m[s1.charAt(i)] = m[s2.charAt(i) + 256] = i + 1;
        }
        return true;
    }

}