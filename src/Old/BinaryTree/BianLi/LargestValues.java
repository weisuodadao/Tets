package src.Old.BinaryTree.BianLi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import src.Old.BinaryTree.TreeNode;

/**
 * @ClassName LargestValues
 * @Description: 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * @Author xianzhuo
 * @Date 2021/8/8 5:07 下午
 * @Version V1.0
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 解释:
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 **/
public class LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            int cnt = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node == null) {
                    continue;
                }
                cnt++;
                max = Math.max(max, node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
            if (cnt > 0) {
                ans.add(max);
            }
        }
        return ans;


    }

}
