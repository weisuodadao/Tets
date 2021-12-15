package src.Old.BinaryTree.BianLi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import src.Old.BinaryTree.TreeNode;

/**
 * @ClassName LevelOrder
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/7/3 6:04 下午
 * @Version V1.0
 * 层序遍历
 **/
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }

    public List<List<Integer>> level(TreeNode root){
        List<List<Integer>> res=new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            List<Integer> level=new ArrayList<>();
            int size=q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode=q.poll();
                level.add(curNode.val);
                if (curNode.left!=null){
                    q.offer(root.left);
                }
                if (curNode.right!=null){
                    q.offer(root.right);
                }
            }
        }
        return res;
    }



}
