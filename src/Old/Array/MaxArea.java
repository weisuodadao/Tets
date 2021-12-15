package src.Old.Array;

/**
 * @ClassName MaxArea
 * @Description:
 * @Author xianzhuo
 * @Date 2021/6/22 3:30 下午
 * @Version V1.0
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * 输入：height = [1,1]
 * 输出：1
 *
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 *
 * 输入：height = [1,2,1]
 * 输出：2
 **/
public class MaxArea {

    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(area, ans);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

    public int max(int[] a) {
        if (a.length < 2) {
            return 0;
        }
        int l = 0;
        int r = a.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.max(a[l], a[r] * (r - l));
            ans = Math.max(area, ans);
            if (a[l] <= a[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

}
