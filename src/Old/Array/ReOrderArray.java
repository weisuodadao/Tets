package src.Old.Array;

/**
 * Created by luoxianzhuo on 2019/3/28 17:17
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class ReOrderArray {
    public void reOrderArray(int[] nums) {
        // 奇数个数
        int oddCnt = 0;
        for (int val : nums) {
            if (val % 2 == 1)
                oddCnt++;
        }
        int[] copy = nums.clone();
        int i = 0, j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1) {
                nums[i++] = num;
            } else {
                nums[j++] = num;
            }

        }
    }


}