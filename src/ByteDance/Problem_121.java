package ByteDance;

public class Problem_121 {
    class Solution {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len < 2) {
                return 0;
            }
            int[][] dp = new int[len][2];
            // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
            // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
            }
            return dp[len - 1][0];
        }
    }
}
