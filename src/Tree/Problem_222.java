package Tree;

public class Problem_222 {
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
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftLevel = countLevel(root.left);
            int rightLevel = countLevel(root.right);
            if (leftLevel == rightLevel) {
                return countNodes(root.right) + (1 << leftLevel);
            } else {
                return countNodes(root.left) + (1 << rightLevel);
            }
        }

        public int countLevel(TreeNode root) {
            int level = 0;
            while (root != null) {
                level++;
                root = root.left;
            }
            return level;
        }
    }
}
