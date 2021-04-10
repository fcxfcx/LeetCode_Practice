package DetailPractice;

import java.util.*;

/**
 * Problem 3. 无重复字符的最长字串
 * 标签：数组，滑动窗口
 */
public class Problem_3 {
    public int lengthOfLongestSubstring(String s) {
        // 使用哈希集合记录每个字符是否出现过
        HashSet<Character> occ = new HashSet<>();
        int length = s.length();
        // 右指针从-1开始计数，可以理解为从第一个字符开始判断
        int right = -1;
        // 储存答案
        int answer = 0;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                // 如果已经获取到了当前左指针下的最大字串，则去除左指针的字符，注意此时的左指针已经是下一个了，因此要减一
                occ.remove(s.charAt(i-1));
            }
            while (right + 1 != length && !occ.contains(s.charAt(right + 1))) {
                // 持续移动右指针，寻找最大字串,直至结束
                occ.add(s.charAt(right + 1));
                right++;
            }
            // 结束当前左指针下的过程后，更新最大字串的长度，此处的i可以认为是左指针的index
            answer = Math.max(answer, right-i+1);
        }
        return answer;
    }
}
