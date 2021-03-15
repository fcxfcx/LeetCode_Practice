package Heap;

import java.util.PriorityQueue;

public class Problem_1046 {
    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
            for(int s : stones){
                pq.offer(s);
            }
            while(pq.size() > 1){
                int y = pq.poll();
                int x = pq.poll();
                if(x != y){
                    pq.offer(y-x);
                }
            }
            return pq.isEmpty()? 0 : pq.peek();
        }
    }
}
