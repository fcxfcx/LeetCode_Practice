package DetailPractice;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 53. 最大子序和
 * 标签：动态规划
 */
public class Problem_53 {
    public int maxSubArray(int[] nums){
        // pre用来表示前缀和，maxLen来表示最大子序和
        int pre = 0;
        int maxNum = nums[0];
        for(int num : nums){
            // 如果前缀和加上当前数是大于当前数的则添加，否则最大的前缀就是当前数了
            pre = Math.max(pre+num,num);
            maxNum = Math.max(maxNum,pre);
        }
        return maxNum;
    }
}
