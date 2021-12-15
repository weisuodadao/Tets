package src.Old.BinaryTree.DiGui;

import src.Old.BinaryTree.TreeNode;

/**
 * Created by luoxianzhuo on 2019/3/28 17:26
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 求二叉树的镜像(判断是否对称)
 */
public class Mirror {


    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return (left.val == right.val) && check(left.left, right.right) && check(left.right, right.left);
    }



    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }

    private void swap(TreeNode root) {
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }

}