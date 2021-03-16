package Greedy;

public class Problem_1716 {
    class Solution {
        public int totalMoney(int n) {
            int total = 0;
            for(int i=0; i<n; i++){
                int week = i/7;
                int day = i%7+1;
                total += week+day;
            }
            return total;
        }
    }
}
