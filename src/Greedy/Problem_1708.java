package Greedy;

public class Problem_1708 {
    class Solution {
        public int[] largestSubarray(int[] nums, int k) {
            int maxIndex = 0;
            int[] result = new int[k];
            for(int i=0; i<=nums.length-k; i++){
                if(nums[i] >= nums[maxIndex]){
                    maxIndex = i;
                }
            }
            for(int j=0; j<k; j++){
                result[j] = nums[maxIndex+j];
            }
            return result;
        }
    }
}
