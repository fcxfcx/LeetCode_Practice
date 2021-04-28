package Offer;

import java.util.HashMap;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 7. 重建二叉树
 * 标签：二叉树，递归
 */
public class Offer_7 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    // 分别储存中序遍历的索引和前序遍历的结果
    HashMap<Integer,Integer> map = new HashMap<>();
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(0,0,inorder.length-1);
    }

    /**
     * 递归重建二叉树的过程
     * @param root 前序遍历中提取的当前树的根节点
     * @param left 中序遍历中提取的当前树的左边界
     * @param right 中序遍历中提取的当前树的右边界
     * @return 重建好的某一子树
     */
    public TreeNode buildTree(int root, int left, int right){
        // 如果越界代表越过了叶子节点，终止递归
        if(left > right) return null;
        // 获取当前树的根节点
        TreeNode node = new TreeNode(preorder[root]);
        // 根据根节点在哈希表中寻找中序遍历对应的索引值
        int index = map.get(preorder[root]);
        // 左子树的根为前序遍历的下一个，而左边界不变，右边界变为了中间索引的前一个
        node.left = buildTree(root+1,left, index-1);
        // 右子树的跟为前序遍历当前根节点加上左子树的节点数量，左边界为中间索引的后一个，右边界不变
        node.right = buildTree(root+(index-1-left+1)+1,index+1,right);
        return node;
    }
}
