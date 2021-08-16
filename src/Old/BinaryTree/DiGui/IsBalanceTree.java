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


    public boolean isBalanceTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getMaxTreeDepth(root.left) - getMaxTreeDepth(root.right)) <= 1) {
            return true;
        } else {
            return false;
        }

    }

    private int getMaxTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getMaxTreeDepth(root.left) + getMaxTreeDepth(root.right);
    }

}
