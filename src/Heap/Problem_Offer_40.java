package Heap;

import java.util.PriorityQueue;

public class Problem_Offer_40{
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int[] ret = new int[k];
            for(int number : arr){
                pq.offer(number);
            }
            for(int i=0; i<k; i++){
                ret[i] = pq.poll();
            }
            return ret;
        }
    }
}
