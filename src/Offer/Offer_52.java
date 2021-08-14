package Offer;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 52. 两个链表的第一个公共节点
 * 标签：双指针
 */
public class Offer_52 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 此题的思路是维护两个指针A和B，开始时分别指向headA和headB的两个头结点，同时开始遍历
        // 当A遍历到A的尾结点则从B的头结点开始，B遍历到B的尾结点则从A的头结点开始
        // 这样当A和B指向公共节点的时候，假设A的长度为a，B的长度为b，公共部分的长度为n
        // 那么此时A走过了a+(b-n)步，B走过了b+(a-n)步，也就是说此时A和B的步数相同
        ListNode A = headA;
        ListNode B = headB;
        while(A != B){
            // 注意java中的==是值比较，对于引用比较的是内存地址的值
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        // 最后返回A或者B都行，如果是null说明没有公共点
        return A;
    }
}
