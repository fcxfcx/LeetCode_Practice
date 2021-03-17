package Greedy;

public class Problem_122 {
    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            for(int i=0; i<prices.length-1; i++){
                int today = prices[i];
                int tomorrow = prices[i+1];
                if(today < tomorrow){
                    profit+= (tomorrow - today);
                }
            }
            return profit;
        }
    }
}
