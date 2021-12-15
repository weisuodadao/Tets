package src.Old.BinaryTree.BianLi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import src.Old.BinaryTree.TreeNode;

/**
 * Created by luoxianzhuo on 2019/8/26 14:52
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class BianLi {

    //前序遍历
    List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            if (node == null) {
                continue;
            }
            ret.add(node.val);
            s.push(node.right);
            s.push(node.left);
        }
        return null;
    }

    //中序遍历
    List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            TreeNode n = s.pop();
            ret.add(n.val);
            cur = n.right;
        }
        return ret;
    }

    //后序遍历
    List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode n = s.pop();
            if (n == null) {
                continue;
            }
            ret.add(n.val);
            s.push(n.left);
            s.push(n.right);
        }
        Collections.reverse(ret);
        return ret;
    }

    //层次遍历
    public List<Integer> levelTravel(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            res.add(temp.val);
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
        return res;
    }

    //层次遍历
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt != 0) {
                TreeNode t = queue.poll();
                if (t == null) {
                    continue;
                }
                ret.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        return ret;
    }

}