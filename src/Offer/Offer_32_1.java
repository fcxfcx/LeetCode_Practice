package Offer;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 32.1 从上到下打印二叉树
 * 标签：二叉树，广度优先遍历
 */
public class Offer_32_1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {
        // 这道题本质上就是二叉树的层序遍历，也就是广度优先遍历，我们往往利用队列的先入后出的特性实现
        // 时间复杂度和空间复杂度为O(n)
        if(root == null){
            return new int[0];
        }
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if(temp.left!= null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
        }
        int[] res = new int[list.size()];
        for(int i=0; i<res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
