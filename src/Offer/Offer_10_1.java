package Offer;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 10.1 斐波那契数列
 * 标签：递归
 */
public class Offer_10_1 {

    public int fib_1(int n) {
        // 对于斐波那契数列这种天然的递归结构，很容易想到递归法去解决
        // 但是如果递归深度过深，可能会造成栈溢出的问题，因此优化成动态规划，使用三变量累加避免空间复杂度过高
        // 优化过后时间复杂度O(n)，空间复杂度O(1)
        int cur = 0;
        int next = 1;
        for(int i=0; i<n; i++){
            int temp = (cur + next) % 1000000007;
            cur = next;
            next = temp;
        }
        return cur;
    }

}
