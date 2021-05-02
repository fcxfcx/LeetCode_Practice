package Offer;

import java.util.LinkedList;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 6. 从尾到头打印链表
 * 标签：链表，递归
 */
public class Offer_6 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        // 本题可以使用递归或者辅助栈的方法完成，时间复杂度和空间复杂度都为O(n)
        // 这两种方法根据本题的要求都需要一个数组来维护结果
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null){
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i=0; i<res.length; i++){
            res[i] = stack.removeLast();
        }
        return res;
    }
}
