package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Problem_103 {
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

    class Solution {
        List<List<Integer>> lists;
        Deque<TreeNode> queue1;
        Deque<TreeNode> queue2;

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            lists = new ArrayList<>();
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
            if (root == null) return lists;
            queue1.push(root);
            oneLevel();
            return lists;
        }

        public void oneLevel() {
            List<Integer> list = new ArrayList<>();
            boolean oneLevelFinish = false;
            if (queue2.isEmpty()) {
                while (!queue1.isEmpty()) {
                    TreeNode node = queue1.pollLast();
                    if (node.left != null) queue2.offer(node.left);
                    if (node.right != null) queue2.offer(node.right);
                    list.add(node.val);
                    oneLevelFinish = true;
                }
            }
            if (queue1.isEmpty() && !oneLevelFinish) {
                while (!queue2.isEmpty()) {
                    TreeNode node = queue2.pollLast();
                    if (node.right != null) queue1.offer(node.right);
                    if (node.left != null) queue1.offer(node.left);
                    list.add(node.val);
                    oneLevelFinish = true;
                }
            }
            lists.add(list);
            if (queue1.isEmpty() && queue2.isEmpty()) return;
            oneLevel();
        }
    }
}
