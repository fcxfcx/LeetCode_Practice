package Tree;

import java.util.Stack;

public class Problem_1628 {
    /**
     * This is the interface for the expression tree Node.
     * You should not remove it, and you can define some classes to implement it.
     */

    abstract class Node {

        public abstract int evaluate();
        // define your fields here
    };


    /**
     * This is the TreeBuilder class.
     * You can treat it as the driver code that takes the postinfix input
     * and returns the expression tree represnting it as a Node.
     */

    class TreeBuilder {
        Node buildTree(String[] postfix) {
            Stack<MyNode> stack = new Stack<>();
            for(String s : postfix){
                MyNode tempNode = new MyNode(s);
                if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)){
                    tempNode.right = stack.pop();
                    tempNode.left = stack.pop();
                }
                stack.push(tempNode);
            }
            return stack.pop();
        }
    };

    public class MyNode extends Node{
        public String val;
        public Node left;
        public Node right;

        public MyNode(String str){
            this.val = str;
        }
        @Override
        public int evaluate(){
            switch (val) {
                case "+":
                    return left.evaluate() + right.evaluate();
                case "-":
                    return left.evaluate() - right.evaluate();
                case"*":
                    return left.evaluate() * right.evaluate();
                case"/":
                    return left.evaluate() / right.evaluate();
                default:
                    return Integer.valueOf(val);
            }
        }
    }
/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
}
