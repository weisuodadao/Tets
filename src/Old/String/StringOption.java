package src.Old.String;

/**
 * Created by luoxianzhuo on 2019/3/25 16:59
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class StringOption {

    /**
     * @author luoxianzhuo
     * @date 2019/3/27 17:23
     * @version V1.0.0
     * @description 字符串相加
     */
    public static String addStrings(String num1, String num2) {
        StringBuilder str = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (carry == 1 || i >= 0 || j >= 0) {
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            str.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }

        return str.reverse().toString();
    }

    /**
     * @author luoxianzhuo
     * @date 2019/3/26 15:08
     * @version V1.0.0
     * @description 字符串乘法
     */
    public String multiply(String num1, String num2) {
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int[] pos = new int[m + n];

        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(StringOption.addStrings("123", "123"));
    }

}