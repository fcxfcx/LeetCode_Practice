package Tree;

import java.util.ArrayList;
import java.util.List;

public class Problem_144 {

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
        List<Integer> list;

        public List<Integer> preorderTraversal(TreeNode root) {
            list = new ArrayList<>();
            preorderTravel(root);
            return list;
        }

        public void preorderTravel(TreeNode root) {
            if (root == null) return;
            list.add(root.val);
            preorderTravel(root.left);
            preorderTravel(root.right);
        }
    }
}
