package src.Old.BinaryTree.BianLi;

import src.Old.BinaryTree.TreeNode;

/**
 * Created by luoxianzhuo on 2019/8/21 16:13
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 合并两个二叉树
 */
public class MergeTree {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;

    }
}