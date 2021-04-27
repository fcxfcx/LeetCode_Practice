package Offer;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 25. 合并两个有序链表
 * 标签：链表，分治算法
 */
public class Offer_25 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 使用双指针遍历两列表且每次都加入更小的一方
        // 使用假头节点维护答案，cur维护当前填充的节点
        // 时间复杂度为O(m+n)，m和n是两链表的长度，空间复杂度为O(1)
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            // 记得维护cur使得cur每次都指向需要填充的节点
            cur = cur.next;
        }
        // 由于链表是有序的，哪一个链表有剩余就直接加在cur之后即可
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
