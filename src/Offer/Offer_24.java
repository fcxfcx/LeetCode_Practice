package Offer;

import java.util.*;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 24. 反转链表
 * 标签：链表
 */
public class Offer_24 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList_1(ListNode head) {
        // 使用迭代的方法，时间复杂度O(n)，空间复杂度O(1)
        ListNode nextNode = head;
        ListNode prevNode = null;
        while(nextNode != null){
            ListNode temp = nextNode.next;
            nextNode.next = prevNode;
            prevNode = nextNode;
            nextNode = temp;
        }
        return prevNode;
    }

    public ListNode reverseList_2(ListNode head){
        // 使用递归的方法，时间复杂度O(n)，空间复杂度O(n)
        if(head == null || head.next==null){
            return head;
        }
        ListNode newHead = reverseList_2(head.next);
        // 反转当前的节点
        head.next.next = head;
        // 切断链表防止成环
        head.next = null;
        return newHead;
    }
}
