package Offer;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 26. 树的子结构
 * 标签：树
 */
public class Offer_26 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 满足条件的一共有三种情况，第一是B是A的子结构，二是B是A左子树的子结构，三是B是A右子树的子结构
        // 子结构的判断通过recur函数实现，时间复杂度为O(MN)，空间复杂度为O(M)，体现为递归深度
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    /**
     * 判断两节点下树结构是否一致
     *
     * @param A A树中的某节点
     * @param B B树中的某节点
     * @return 两节点下结构是否相同
     */
    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            // 如果B树为空则说明已经匹配完成
            return true;
        }
        if (A == null || A.val != B.val) {
            // 如果A树为空或者当前两节点值不一样则说明匹配失败
            return false;
        }
        // 如果都符合则继续向下搜索
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
