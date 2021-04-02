package ByteDance;

public class Problem_53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int answer = nums[0];
            int sum = 0;
            for(int num : nums){
                if(sum > 0){
                    sum = sum + num;
                }else{
                    sum = num;
                }
                answer = Math.max(sum, answer);
            }
            return answer;
        }
    }
}
