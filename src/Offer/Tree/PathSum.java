package src.Offer.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import src.Old.BinaryTree.TreeNode;

/**
 * @ClassName PathSum
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/7/5 5:15 下午
 * @Version V1.0
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *给定如下二叉树，以及目标和 target = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 *  返回：[
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 **/
public class PathSum {

    List<List<Integer>> ret = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return ret;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        target = target - root.val;
        if (root.left == null && root.right == null && root.val == target) {
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.pollLast();
    }


}
