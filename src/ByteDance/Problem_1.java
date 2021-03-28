package ByteDance;

import java.util.HashMap;

public class Problem_1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] ret = new int[2];
            int length = nums.length;
            for (int j = 0; j < length; j++) {
                if (map.containsKey(target - nums[j])) {
                    return new int[]{map.get(target - nums[j]), j};
                }
                map.put(nums[j], j);
            }
            return new int[0];
        }
    }
}
