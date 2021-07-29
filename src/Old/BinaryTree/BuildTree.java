package src.Old.BinaryTree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName BuildTree
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/7/11 7:34 下午
 * @Version V1.0
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]

返回如下的二叉树：

3
/ \
9  20
/  \
15   7
 **/
public class BuildTree {

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] pre, int[] in, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int inorderIndex = 0;
        for (int i = 0; i < pre.length; i++) {

            int preOrderVal = pre[i];
            TreeNode node = deque.peek();
            if (node.val != in[inorderIndex]) {
                node.left = new TreeNode(preOrderVal);
                deque.push(node.left);
            } else {
                while (!deque.isEmpty() && deque.peek().val == inorderIndex) {
                    node = deque.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preOrderVal);
                deque.push(node.right);
            }
        }
        return root;

    }


}
