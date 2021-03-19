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

    //在 BST 中搜索一个数
    void isInBST(TreeNode root, int target) {
        if (root.val == target) {
            return;
        }
        if (root.val < target) {
            isInBST(root.right, target);
        }
        if (root.val > target) {
            isInBST(root.left, target);
        }

    }

    //在BST中插入一个数
    TreeNode insertBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertBST(root.right, val);

        }
        if (root.val > val) {
            root.left = insertBST(root.left, val);
        }
        return root;
    }

    //在BST中删除一个数
    TreeNode deleteBST(TreeNode root, int val) {
        if (root.val == val) {
            //删除逻辑
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteBST(root.right, minNode.val);

        } else if (root.val < val) {
            root.right = deleteBST(root.right, val);
        } else if (root.val > val) {
            root.left = deleteBST(root.left, val);
        }
        return root;
    }


    TreeNode getMin(TreeNode root) {
        // BST 最左边的就是最小的
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }


}
