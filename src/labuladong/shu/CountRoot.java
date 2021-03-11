package src.labuladong.shu;

/**
 * @ClassName CoutRoot
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/3/9 7:21 下午
 * @Version V1.0
 *
 * count(root) 返回以 root 为根的树有多少节点
 **/
public class CountRoot {

    public int count(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        // 自己加上子树的节点数就是整棵树的节点数
        return 1 + count(root.left) + count(root.right);
    }

}
