package src.Old.BinaryTree;

/**
 * @ClassName IsValidBST
 * @Description:
 * @Author xianzhuo
 * @Date 2021/6/29 4:21 下午
 * @Version V1.0
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 **/
public class IsValidBST {

    public boolean isValidBst(TreeNode root) {
        return isValidBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBst(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return isValidBst(root.left, lower, root.val) && isValidBst(root.right, root.val, upper);
    }

}
