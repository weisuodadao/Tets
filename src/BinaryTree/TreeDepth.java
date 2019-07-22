package src.BinaryTree;

/**
 * Created by luoxianzhuo on 2019/3/28 17:33
 * 二叉树的深度
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class TreeDepth {

    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

}