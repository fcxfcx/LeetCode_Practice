package Offer;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 46. 把数字翻译成字符串
 * 标签：动态规划
 */
public class Offer_46 {
    public int translateNum(int num) {
        // 假设在第i位置的数为xi，可翻译方式为f(i)，那么xi可以单独翻译，也可能与xi-1一起翻译
        // 此处的判读条件是x(i-1)xi小于26并且大于9（因为第一位不能是0），此时f(i) = f(i-1) + f(i-2)
        // 如果单独翻译,f(i) = f(i-1)，这是一个天然的动态规划思路，由于最后只用取f(n)，所以依然用三数累加减小空间复杂度
        // 时间复杂度为O(n)，空间复杂度为O(n)，注意此处的空间复杂度体现在字符串上
        String s = String.valueOf(num);
        // 此处的a相当于f(0)，b相当于f(1)
        int a = 1, b = 1;
        for(int i=2; i<=s.length(); i++){
            String temp = s.substring(i-2,i);
            int c = temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0 ? a+b : b;
            a = b;
            b = c;
        }
        return b;
    }
}
