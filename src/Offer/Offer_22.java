package Offer;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 22. 链表中倒数第k个节点
 * 标签：快慢指针，链表
 */
public class Offer_22 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 使用双指针方法，维护快慢指针可以在遍历一次的情况下获取结果
        // 时间复杂度是O(n)，空间复杂度是O(1)
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
