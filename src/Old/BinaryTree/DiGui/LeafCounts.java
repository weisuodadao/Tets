package src.Old.BinaryTree.DiGui;

import src.Old.BinaryTree.TreeNode;

/**
 * Created by luoxianzhuo on 2019/9/2 18:43
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 二叉树叶子节点数目
 */
public class LeafCounts {

    public int leafCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return leafCount(root.left) + leafCount(root.right);
    }

    int countLeaf(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeaf(root.left) + countLeaf(root.right);
    }
}