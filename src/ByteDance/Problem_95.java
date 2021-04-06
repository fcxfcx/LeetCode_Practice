package ByteDance;

public class Problem_95 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummyNode = new ListNode(-1);
            dummyNode.next = head;
            ListNode pre = dummyNode;
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }
            ListNode rightNode = pre;
            for (int i = 0; i < right - left + 1; i++) {
                rightNode = rightNode.next;
            }
            ListNode leftNode = pre.next;
            ListNode scc = rightNode.next;
            // 切断链表
            pre.next = null;
            rightNode.next = null;
            reverseList(leftNode);
            pre.next = rightNode;
            leftNode.next = scc;
            return dummyNode.next;
        }

        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }
            return prev;
        }
    }
}
