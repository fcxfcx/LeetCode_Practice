package DetailPractice;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 70. 爬楼梯
 * 标签：动态规划，滚动数组
 */
public class Problem_70 {
    public int climbStairs(int n) {
        // 假设f(x)是爬到x级楼梯的方法数，那么我们可以得出f(x)=f(x-1)+f(x-2)
        // 爬到第一级或者第二级的方法都只有一个
        // r初始表示第三阶的方法数
        int p=0, q=0, r=1;
        for(int i=1; i<=n; i++){
            // 进行滚动数组操作
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
