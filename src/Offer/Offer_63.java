package Offer;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 63. 股票的最大利润
 * 标签：动态规划
 */
public class Offer_63 {
    public int maxProfit(int[] prices) {
        // 我们可以设想对于每一天的价格，我们一定希望买入时价格最低，那么利润就最高
        // 由于没有规定哪一天买，因此对于每一天我们都可以认为我们能买到之前最低价的股票
        // 时间复杂度为O(n)，空间复杂度O(1)
        if(prices.length < 2){
            return 0;
        }
        int minPrice = prices[0];
        int answer = 0;
        for(int i=0; i<prices.length; i++){
            int profit = prices[i]-minPrice;
            minPrice = Math.min(minPrice, prices[i]);
            answer = Math.max(answer, profit);
        }
        return answer;
    }
}
