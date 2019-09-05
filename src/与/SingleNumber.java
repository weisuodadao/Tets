package src.与;

/**
 * Created by luoxianzhuo on 2019/3/28 19:51
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 数组中单独的数
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret = ret ^ n;
        }
        return ret;
    }

}