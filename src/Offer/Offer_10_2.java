package Offer;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 10.2 青蛙跳台阶问题
 * 标签：动态规划
 */
public class Offer_10_2 {
    public int numWays(int n) {
        // 假设跳到n级台阶有f(n)种方法，那么很容易得出f(n) = f(n-1)+f(n-2)，和斐波那契数列一致
        // 那么我们可以使用动态规划的方法进行递归，并使用三变量累加的方式优化空间复杂度至O(1)，时间复杂度O(n)
        // 爬到第一级和第二级的方法都是1，a从第一级开始计算，b从第二级开始算
        int a = 1;
        int b = 1;
        for (int i = 0; i < n; i++) {
            int sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
