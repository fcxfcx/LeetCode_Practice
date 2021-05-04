package Offer;

import java.util.HashSet;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 48. 最长不含重复字符的子串
 * 标签：滑动窗口，双指针
 */
public class Offer_48 {
    public int lengthOfLongestSubstring(String s) {
        // 我们使用两个指针维护一个滑动窗口，如果当前窗口内的子串是符合题意的，那么我们将左边界右移一位时的子串仍是符合的
        // 我们依次移动左边界并寻找满足最大子串的右边界，维护一个结果遍历储存全局最大值
        // 这里右边界从-1开始记录，并且使用哈希表来判断是否含有重复字符
        HashSet<Character> set = new HashSet<Character>();
        int answer = 0;
        int right = -1;
        if (s.length() < 1) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            // 此处的i就是左边界
            if (i != 0) {
                // 除了第一次，都需要维护哈希表
                set.remove(s.charAt(i - 1));
            }
            while (right < s.length() - 1 && !set.contains(s.charAt(right + 1))) {
                right++;
                set.add(s.charAt(right));
            }
            answer = Math.max(answer, right + 1 - i);
        }
        return answer;
    }
}
