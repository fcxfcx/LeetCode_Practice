package ByteDance;

import java.util.PriorityQueue;

public class Problem_215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int num : nums) {
                heap.add(num);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
            return heap.peek();
        }
    }
}
