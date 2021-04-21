package DetailPractice;

import java.util.*;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 199. 二叉树的右视图
 * 标签：二叉树，层序遍历
 */
public class Problem_199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        queue.offer(root);
        while(!queue.isEmpty()){
            // 当前层的节点数
            int levelSize = queue.size();
            for(int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                // 先处理左节点，之后出队列的时候最后剩下的就是最右节点
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if(i == levelSize-1){
                    list.add(node.val);
                }
            }
        }
        return list;
    }
}
