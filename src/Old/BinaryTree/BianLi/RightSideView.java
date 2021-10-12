package src.Old.BinaryTree.BianLi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import src.Old.BinaryTree.TreeNode;

/**
 * @ClassName RightSideView
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/8/8 5:35 下午
 * @Version V1.0
 * 二叉树的右侧视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 *
 * 层序遍历
 **/
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                    //最右子节点
                    if (i == size - 1) {
                        res.add(cur.val);
                    }
                }
        }
        return res;
    }

}
