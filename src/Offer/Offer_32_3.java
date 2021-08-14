package Offer;

import javax.xml.soap.Node;
import java.util.*;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * 剑指Offer 32-Ⅲ 从上到下打印二叉树
 * 标签：树，广度优先搜索
 */
public class Offer_32_3 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root){
        if(root == null){
            return new LinkedList<>();
        }
        List<List<Integer>> returnList = new LinkedList<>();
        // 代表层数，每一层最多会有2^level个节点
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            LinkedList<Integer> temp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(level % 2 == 1) temp.addLast(node.val);
                else temp.addFirst(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            returnList.add(temp);
            level++;
        }
        return  returnList;
    }
}
