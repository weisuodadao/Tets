package src.Old.BinaryTree;

/**
 * @ClassName IsSubStructure
 * @Description:
 * @Author xianzhuo
 * @Date 2021/7/12 8:46 下午
 * @Version V1.0
 *
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *    3
 *   / \
 *  4  5
 *  / \
 * 1  2
 * 给定的树 B：
 *
 *  4
 *  /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 **/
public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        if (A.val == B.val && (helper(A.left, B.left) && helper(A.right, B.right))) {
            return true;
        }

        return isSubStructure(A.left, B) || isSubStructure(A.right, B);


    }

    private boolean helper(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        if (t1.val == t2.val) {
            return helper(t1.left, t2.left) && helper(t1.right, t2.right);
        } else {
            return false;
        }

    }

}
