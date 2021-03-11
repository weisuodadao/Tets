package src.labuladong.shu;

/**
 * @ClassName IsValidBST
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/3/11 4:23 下午
 * @Version V1.0
 * 判断 二叉搜索树 的合法性
 **/
public class IsValidBST {

    public boolean isValidBst(TreeNode root) {
        return isValidBst(root, null, null);
    }

    boolean isValidBst(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && min.val >= root.val) {
            return false;
        }
        if (max != null && max.val <= root.val) {
            return false;
        }
        //限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBst(root.left, min, root) &&
            isValidBst(root.right, root, max);


    }


}
