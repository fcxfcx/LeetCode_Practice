package Greedy;

public class Problem_1725 {
    class Solution {
        public int countGoodRectangles(int[][] rectangles) {
            int maxLen = 0;
            int result = 1;
            for(int[] rectangle : rectangles){
                int value = Math.min(rectangle[0], rectangle[1]);
                if(value > maxLen){
                    maxLen = value;
                    result = 1;
                }else if(value == maxLen){
                    result ++;
                }
            }
            return result;
        }
    }
}
