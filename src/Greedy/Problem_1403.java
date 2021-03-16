package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_1403 {
    class Solution {
        public List<Integer> minSubsequence(int[] nums) {
            List<Integer> ret = new ArrayList();
            int total = 0;
            int current = 0;
            for(int i : nums){
                total += i;
            }
            Arrays.sort(nums);
            for(int i=nums.length-1; i>=0; i--){
                if(current+ nums[i] > total/2){
                    ret.add(nums[i]);
                    break;
                }else{
                    ret.add(nums[i]);
                    current += nums[i];
                }
            }
            return ret;
        }
    }
}
