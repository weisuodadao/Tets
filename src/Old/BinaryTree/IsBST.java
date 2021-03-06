package src.Old.BinaryTree;

import java.util.Stack;

/**
 * Created by luoxianzhuo on 2019/9/2 18:46
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class IsBST {
    public boolean isBST(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = node, pre = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode t = stack.pop();
            if (pre != null && t.val <= pre.val) {
                return false;
            }
            pre = t;
            p = t.right;
        }
        return true;
    }
}