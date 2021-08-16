package src.Offer.Tree;

import src.Old.BinaryTree.TreeNode;

/**
 * @ClassName PruneTree
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/8/8 5:43 下午
 * @Version V1.0
 *
 * 给定一个二叉树 根节点root，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。0作为父节点不减掉
 *
 *
 * 节点 node 的子树为node 本身，以及所有 node的后代。
 * 输入: [1,1,0,1,1,0,1,0]
 * 输出: [1,1,0,1,1,null,1]
 *
 **/
public class PruneTree {

    public TreeNode pruneTree(TreeNode root){
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

}
