package DetailPractice;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 1014. 最佳观光组合
 * 标签：数组，动态规划
 */
public class Problem_1014 {
    public int maxScoreSightseeingPair(int[] values) {
        // 从i点到f点（i<j）的得分可以表达为A[i]+A[j]-(j-i)
        // 这个公式可以表示为（A[i]+i)+(A[j]-j)
        // 如果我们从前往后遍历j，那么每一个j点的值是一定的，当前最大的得分取决于i点的评分
        // 因此我们需要不断维护j点之前的max值（i点），避免每一次遍历j都需要遍历i
        int ans = 0;
        // max用啦存储j点之前的最大i点评分
        int max = values[0];
        for(int j=1; j< values.length; j++){
            ans = Math.max(ans,max+values[j]-j);
            // 注意每次遍历需要维护max，保证每次的max都是当前的最大值
            max = Math.max(max,values[j]+j);
        }
        return ans;
    }
}
