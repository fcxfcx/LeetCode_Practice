package Tree;

import java.util.HashMap;

public class Problem_105 {
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
        public HashMap<Integer, Integer> hashMap;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            hashMap = new HashMap<>();
            for (int i = 0; i < preorder.length; i++) {
                hashMap.put(inorder[i], i);
            }
            return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
        }

        public TreeNode buildTree(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
            if (p_start == p_end) return null;
            int rootVal = preorder[p_start];
            TreeNode node = new TreeNode(rootVal);
            int rootIndex = hashMap.get(rootVal);
            int leftLength = rootIndex - i_start;
            node.left = buildTree(preorder, p_start + 1, p_start + leftLength + 1, inorder, i_start, rootIndex);
            node.right = buildTree(preorder, p_start + leftLength + 1, p_end, inorder, rootIndex + 1, i_end);
            return node;
        }
    }
}
