package Tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem_102 {
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
        public Stack<TreeNode> stack;
        public List<List<Integer>> lists;

        public List<List<Integer>> levelOrder(TreeNode root) {
            stack = new Stack<>();
            lists = new ArrayList<>();
            if (root == null) return lists;
            stack.push(root);
            oneLevel();
            return lists;
        }

        public void oneLevel() {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> tempStack = new Stack<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                //辅助栈先压入左子树再压入右子树，之后换到主栈顺序就是对的
                if (node.left != null) {
                    tempStack.push(node.left);
                }
                if (node.right != null) {
                    tempStack.push(node.right);
                }
            }
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
            lists.add(list);
            if (stack.isEmpty()) return;
            oneLevel();
        }
    }
}
