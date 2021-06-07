package src.Old.BinaryTree;

/**
 * Created by luoxianzhuo on 2019/3/28 17:27
 *
 * @author luoxianzhuo
 * 对称的二叉树
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class IsSymmetrical {

    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        if (t1.val != t2.val) {
            return false;
        }
        return isSymmetrical(t1.left, t2.right) && isSymmetrical(t1.right, t2.left);
    }

}