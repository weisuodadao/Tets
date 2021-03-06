package src.Old.与;

/**
 * Created by luoxianzhuo on 2019/3/28 19:52
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 数组元素在 0-n 之间，但是有一个数是缺失的，要求找到这个缺失的数。
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = ret ^ i ^ nums[i];
        }
        return ret ^ nums.length;
    }

}