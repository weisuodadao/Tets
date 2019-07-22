package src;

import java.math.BigDecimal;

/**
 * Created by luoxianzhuo on 2019/3/19 21:08
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class Test {
    public static void main(String[] args) {
        double number = 0;
        BigDecimal bd = new BigDecimal("-134.3E4");
        number =  Double.parseDouble(bd.toPlainString());

        System.out.println(number);
    }
}