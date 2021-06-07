package src.Old.BinaryTree;

/**
 * @ClassName MinDepth
 * @Description:
 * @Author xianzhuo
 * @Date 2021/4/16 5:55 下午
 * @Version V1.0
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 **/
public class MinDepth {

    //递归
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if ((root.left == null && root.right == null)) {
            return 1;
        }
        //如果左孩子和右孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);

        //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1
        if (root.left == null || root.right == null) {
            return left + right + 1;
        }
        //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        return Math.min(left, right) + 1;

    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int m1 = minDepth2(root.left);
        int m2 = minDepth2(root.right);
        //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
        //2.如果都不为空，返回较小深度+1
        return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1, m2) + 1;
    }

}
