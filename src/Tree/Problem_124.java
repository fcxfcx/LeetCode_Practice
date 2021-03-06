package Tree;

public class Problem_124 {

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
        int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxGain(root);
            return this.maxSum;
        }

        public int maxGain(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftGain = Math.max(maxGain(node.left), 0);
            int rightGain = Math.max(maxGain(node.right), 0);
            int gain = node.val + leftGain + rightGain;

            maxSum = Math.max(maxSum, gain);
            return node.val + Math.max(leftGain, rightGain);
        }
    }
}
