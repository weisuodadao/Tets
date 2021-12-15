package src.Old.BinaryTree.DiGui;

import src.Old.BinaryTree.TreeNode;

/**
 * @ClassName SumNumbers
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/8/8 5:56 下午
 * @Version V1.0
 * 给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 *
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 *
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 *
 **/
public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sum(root, 0);
    }



    private int sum(TreeNode root, int num) {
        if (root==null){
            return 0;
        }
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            return num;
        }
        return sum(root.left, num) + sum(root.right, num);
    }

    int sum1(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            return num;
        }
        return sum1(root.left, num) + sum(root.right, num);
    }

}
