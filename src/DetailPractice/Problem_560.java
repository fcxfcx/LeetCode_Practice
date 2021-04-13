package DetailPractice;

import java.util.*;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 560. 和为K的子数组
 * 标签：哈希表
 */
public class Problem_560 {
    public int subarraySum(int[] nums, int k) {
        // 用哈希表存储子数组之和以及它们的数量
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        // 初始化哈希表，填入0，1可以保证前缀和直接等于K的情况,这里的1是因为之后的循环过程中是先取same再维护map
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            int target = map.getOrDefault(sum - k, 0);
            int same = map.getOrDefault(sum, 0);
            ans += target;
            map.put(sum, same + 1);
        }
        return ans;
    }
}
