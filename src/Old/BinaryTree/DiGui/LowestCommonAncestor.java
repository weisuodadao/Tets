package src.Old.BinaryTree.DiGui;

import src.Old.BinaryTree.TreeNode;

/**
 * Created by luoxianzhuo on 2019/3/27 15:41
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 星标
 */
public class LowestCommonAncestor {

    /**
     * @author luoxianzhuo
     * @date 2019/3/27 15:41
     * @version V1.0.0
     * @description 二叉树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        //递归
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //判断祖先
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
    TreeNode lowest(TreeNode root,TreeNode p,TreeNode q){
        if (root==null||root==p||root==q)return root;
        TreeNode left=lowest(root.left,p,q);
        TreeNode right=lowest(root.right,p,q);

        if (left != null && right != null) {
            return root;
        }
        if (left!=null)return left;
        if (right!=null)return right;
        return null;
    }

}