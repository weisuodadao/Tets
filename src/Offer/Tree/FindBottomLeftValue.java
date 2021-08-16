package src.Offer.Tree;

import java.util.LinkedList;
import java.util.Queue;
import src.Old.BinaryTree.TreeNode;

/**
 * @ClassName FindBottomLeftValue
 * @Description:
 * @Author xianzhuo
 * @Date 2021/8/8 5:15 下午
 * @Version V1.0
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 *
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *
 * 解题思路
 * 记录一层中最左边的值为答案，如果还有下一层就更新答案
 **/
public class FindBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        int res = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = q.poll();
                if (i == 0) {
                    res = curNode.val;
                }
                if (curNode.left != null) {
                    q.offer(curNode.left);
                }
                if (curNode.right != null) {
                    q.offer(curNode.right);
                }
            }
        }
        return res;

    }

}
