package Offer;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 39. 数组中出现超过一半的数字
 */
public class Offer_39 {
    public int majorityElement(int[] nums){
        // 这题的本质可以看成查询众数，我们使用摩尔投票法可以做到O(1)级别的空间复杂度
        // 投票法的逻辑是维护一个假设数作为当前假设的众数，遍历每一个数，如果等于假设数则记为正票，否则记录为负票数
        // 按照这个计票方法，如果存在众数那么最后的票数一定是大于0的，那么如果某一刻票数等于0了，那么之后的票数一定大于0，也就是说后面数组的众数依然是整个数组的众数
        // 因此我们可以在票数置零后重新维护假设数
        int predict = 0;
        int vote =0;
        for(int i : nums){
            if(vote == 0){
                predict = i;
            }
            vote += i==predict ? 1 : -1;
        }
        return predict;
    }
}
