package src.Old.Array;

/**
 * @ClassName MoveZero
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/4/1 3:49 下午
 * @Version V1.0
 *
 *  给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 *  输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 **/
public class MoveZero {

    public void moveZero(int[] nums) {
        if (nums.length < 1) {
            return;
        }
        int left = 0;
        int right = 0;
        int n = nums.length - 1;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = b;
        b = a;
        a = tmp;
    }

}
