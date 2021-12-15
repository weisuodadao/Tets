package src.Old.BinaryTree.BianLi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import src.Old.BinaryTree.TreeNode;

/**
 * Created by luoxianzhuo on 2019/9/8 16:00
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 * 之字形顺序打印二叉树
 */
public class ZigzagLevelOrder {


    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0) {
                    tmp.addLast(node.val); // 偶数层 -> 队列头部
                } else {
                    tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    List<List<Integer>> z(TreeNode node){
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if (node!=null){
            q.add(node);
        }
        while (!q.isEmpty()){
            LinkedList<Integer> tmp=new LinkedList<>();
            for (int i = q.size();i >0;i--) {
                TreeNode t=q.poll();
                if(res.size()%2==0){
                    tmp.addLast(t.val);
                }else {
                    tmp.addFirst(t.val);
                }
                if (t.left!=null){
                    q.add(t.left);
                }
                if (t.right!=null){
                    q.add(t.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }


    public ArrayList<ArrayList<Integer>> PrintZ(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            //循环判断cnt自减后大于0
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (reverse) {
                Collections.reverse(list);
            }
            reverse = !reverse;
            if (list.size() != 0) {
                ret.add(list);
            }

        }
        return ret;
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
        if (curr == null) {
            return;
        }
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