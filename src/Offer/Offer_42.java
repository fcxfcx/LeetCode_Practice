package Offer;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 42. 连续子数组的最大值
 * 标签：动态规划
 */
public class Offer_42 {
    public int maxSubArray(int[] nums) {
        // 使用动态规划，假设dp[i]表示至i为止的最大子数组，那么很容易想到如果dp[i-1]为负数，对dp[i]就是负贡献
        // 此时dp[i]必然就是nums[i]，否则dp[i]就是dp[i-1]+nums[i]，如此可以推算出最后的最大值
        // 在实际操作中，我们不必要维护一个dp数组来进行数据存储，dp[i]只与dp[i-1]和nums[i]有关系
        // 因此可以将原数组 nums 用作 dp 列表，即直接在 nums 上修改即可。
        // 只用一个int值来存储当前最大值，空间复杂度可以达到O(1)，时间复杂度为O(n)
        int res = nums[0];
        for(int i=1; i<nums.length; i++){
            // 这一步相当于直接将nums当dp使用
            nums[i] += Math.max(0,nums[i-1]);
            res = Math.max(res,nums[i]);
        }
        return res;
    }
}
