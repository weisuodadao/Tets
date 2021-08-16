package src.Old.Array;

/**
 * Created by luoxianzhuo on 2019/9/5 22:59
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 无序数组中重复的数字
 */
public class Duplicate {
    public int duplicate(int[] nums) {
        int length = nums.length;
        if (nums == null || length <= 0) {
            return -1;
        }
        int[] duplication = new int[1];
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return duplication[0];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] i = {2, 3, 1, 0, 2, 5};
        Duplicate d = new Duplicate();
        System.out.println(d.duplicate(i));
    }

}