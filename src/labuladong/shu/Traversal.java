package src.labuladong.shu;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Traversal
 * @Description:
 * @Author xianzhuo
 * @Date 2021/3/19 4:05 下午
 * @Version V1.0
 *
 * 二叉树的各种遍历
 **/
public class Traversal {

    //二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);

    }

    //二叉树的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;

    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

}
