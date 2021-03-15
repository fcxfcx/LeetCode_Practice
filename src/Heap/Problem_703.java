package Heap;

import java.util.PriorityQueue;

public class Problem_703 {
    class KthLargest {
        PriorityQueue<Integer> pq;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<Integer>();
            for(int num : nums){
                add(num);
            }
        }

        public int add(int val) {
            pq.offer(val);
            if(pq.size() > k){
                pq.poll();
            }
            return pq.peek();
        }
    }
}
