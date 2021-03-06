package src.Old.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

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

    //非递归实现
    public int findDeep2(TreeNode root) {
        if (root == null) return 0;

        TreeNode current;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cur, last;
        int level = 0;
        while (!queue.isEmpty()) {
            cur = 0;//记录本层已经遍历的节点个数
            last = queue.size();//当遍历完当前层以后，队列里元素全是下一层的元素，队列的长度是这一层的节点的个数
            while (cur < last) {//当还没有遍历到本层最后一个节点时循环
                current = queue.poll();//出队一个元素
                cur++;
                //把当前节点的左右节点入队（如果存在的话）
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            level++;//每遍历完一层level+1
        }
        return level;
    }

}