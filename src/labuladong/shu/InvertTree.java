package src.labuladong.shu;

/**
 * @ClassName InvertTree
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/3/9 7:28 下午
 * @Version V1.0
 *
 * 翻转二叉树
 **/
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //前序遍历
        // root 节点需要交换它的左右子节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root = tmp;

        // 让左右子节点继续翻转它们的子节点
        invertTree(root.left);
        invertTree(root.right);

        return root;

    }


}
