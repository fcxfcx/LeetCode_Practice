package Sort;

import java.util.PriorityQueue;

public class Problem_23 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ComparableListNode> pq = new PriorityQueue<>();
            for(ListNode listNode : lists){
                if(listNode != null) pq.offer(new ComparableListNode(listNode));
            }
            ListNode dummyHead = new ListNode(0);
            ListNode tail = dummyHead;
            while(!pq.isEmpty()){
                ComparableListNode temp = pq.poll();
                tail.next = temp;
                tail = tail.next;
                if(temp.next!=null){
                    pq.offer(new ComparableListNode(temp.next));
                }
            }
            return dummyHead.next;
        }

        public  class ComparableListNode extends ListNode implements Comparable<ComparableListNode>{
            public ComparableListNode(ListNode node){
                this.val = node.val;
                this.next = node.next;
            }

            @Override
            public int compareTo(ComparableListNode other){
                return val-other.val;
            }
        }
    }
}
