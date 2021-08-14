package Offer;

/**
 * @author Chuxing, Fang
 * @version 1.0
 */
public class Offer_27 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        // 递归遍历二叉树,交换其左右节点，终止条件为越过叶子节点
        // 时间复杂度O(n)，空间复杂度为O(n)
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}
