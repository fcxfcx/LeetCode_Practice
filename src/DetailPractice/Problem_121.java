package DetailPractice;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 121. 买卖股票的最佳时机
 * 标签: 动态规划
 */
public class Problem_121 {
    public int maxProfit(int[] prices) {
        // 暴力法的思想是在每一天的价格基础上去寻找之前的最小值，遍历后获取最大利润
        // 在这种思路下我们很容易想到优化方式，由于买卖股票的日期是不设限制的，我们可以理解为当天以前的任一天我们都可以买股票
        // 也就是说我们只需要记录一个历史最小值，并且对于每日价格维护这个最小值，就不必遍历去寻找历史最小值了
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i] < minValue){
                // 如果当前值小于历史最小值，则更新它
                minValue = prices[i];
            }else if(prices[i]-minValue > maxProfit){
                maxProfit = prices[i] - minValue;
            }
        }
        return maxProfit;
    }
}
