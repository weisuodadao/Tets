package src.Old.String;

import java.util.BitSet;

/**
 * Created by luoxianzhuo on 2019/3/28 17:30
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。
 */
public class FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        int[] cnts = new int[256];
        for (int i = 0; i < str.length(); i++) {
            cnts[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (cnts[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int FirstNotRepeatingChar2(String str) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c)) {
                bs1.set(c);     // 0 0 -> 0 1
            } else if (bs1.get(c) && !bs2.get(c)) {
                bs2.set(c);     // 0 1 -> 1 1
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (bs1.get(c) && !bs2.get(c))  // 0 1
            {
                return i;
            }
        }
        return -1;
    }


}