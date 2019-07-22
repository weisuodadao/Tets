package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by luoxianzhuo on 2019/3/27 15:41
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class BinaryTree {

    /**
     * @author luoxianzhuo
     * @date 2019/3/27 15:41
     * @version V1.0.0
     * @description 二叉树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

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


    /**
     * @author luoxianzhuo
     * @date 2019/3/27 15:42
     * @version V1.0.0
     * @description 二叉树的锯齿形层次遍历
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }

    private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
        if (curr == null) return;
        if (sol.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }
        List<Integer> list = sol.get(level);
        if (level % 2 == 0) {
            list.add(curr.val);
        } else {
            list.add(0, curr.val);
        }
        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }
}