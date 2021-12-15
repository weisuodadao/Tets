package src.Old.String;

/**
 * Created by luoxianzhuo on 2019/8/26 14:13
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class ATOI {

    public static int myAtoi(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int sign = 1, base = 0, i = 0, n = s.length();
        //剔除空格
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        //正负号
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i++) == '+') ? 1 : -1;
        }
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) < '9') {
            base = base * 10 + (s.charAt(i) - '0');
            i++;
        }
        base = sign * base;
        //int阈值
        if (base > Integer.MAX_VALUE) {
            base = Integer.MAX_VALUE;
        } else if (base < Integer.MIN_VALUE) {
            base = Integer.MIN_VALUE;
        }
        return base;
    }

    int atoi(String s){
        if (s.isEmpty())return 0;
        int sign=1,base=0,i=0,n=s.length();
        //剔除空格
        while (i<n&&s.charAt(i)==' '){
            i++;
        }
        //正负号
        if (s.charAt(i)=='+'||s.charAt(i)=='-'){
            sign=(s.charAt(i++)=='+')?1:-1;
        }

        while (i<n&&s.charAt(i)>='0'&&s.charAt(i)<'9'){
            base=base*10+(s.charAt(i)-'0');
            i++;
        }
        base=sign*base;
        //阈值
        if (base>Integer.MAX_VALUE){
            base=Integer.MAX_VALUE;
        }else if (base<Integer.MIN_VALUE){
            base=Integer.MIN_VALUE;
        }
        return base;
    }


}