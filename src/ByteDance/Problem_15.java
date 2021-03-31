package ByteDance;

import java.util.*;

public class Problem_15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            int length = nums.length;
            if (length <= 2 || nums == null) {
                return ret;
            }
            Arrays.sort(nums);

            for (int i = 0; i < length - 2; i++) {
                // 第一个数大于0那么往后的数只能更大
                if (nums[i] > 0) continue;
                // 跳过相同的数
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int left = i + 1;
                int right = length - 1;
                int target = -nums[i];
                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        ret.add(new ArrayList(Arrays.asList(nums[i], nums[left], nums[right])));
                        // 增加left，减小right，但是重复的数字不能算
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (nums[left] + nums[right] < target) {
                        //如果两数相加不够大就将左边数增大
                        left++;
                    } else {
                        //如果两数相加过大则将右边数减小
                        right--;
                    }
                }
            }
            return ret;
        }
    }
}
