package Greedy;

import java.util.Arrays;

public class Problem_1196 {
    class Solution {
        public int maxNumberOfApples(int[] arr) {
            Arrays.sort(arr);
            int count = 0;
            int weight = 0;
            for(int i=0; i<arr.length; i++){
                weight += arr[i];
                count ++;
                if(weight > 5000){
                    return count - 1;
                }
            }
            return count;
        }
    }
}
