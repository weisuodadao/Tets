package src.Old.BinaryTree.DiGui;

import src.Old.BinaryTree.TreeNode;

/**
 * @ClassName IsBalanceTree
 * @Description: 判断平衡二叉树
 * @Author xianzhuo
 * @Date 2021/8/10 4:24 下午
 * @Version V1.0
 **/
public class IsBalanceTree {


    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }


}
