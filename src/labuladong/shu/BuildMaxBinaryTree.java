package src.labuladong.shu;

/**
 * @ClassName BuildMaxBinaryTree
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/3/10 5:38 下午
 * @Version V1.0
 *
 *  给一个数组构造最大二叉树
 **/
public class BuildMaxBinaryTree {

    TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);


    }

    private TreeNode build(int[] nums, int lo, int hi) {
        if (nums.length < 1) {
            return null;
        }
        if (lo < hi) {
            return null;
        }

        // 找到数组中的最大值和对应的索引
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = lo; i < hi; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }

        }
        TreeNode root = new TreeNode(maxVal);
        // 递归调用构造左右子树
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);
        return root;

    }

}
