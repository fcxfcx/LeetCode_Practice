package DetailPractice;

import java.util.*;

/**
 * @author Chuxing, Fang
 * @version 1.0
 */
public class Problem_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 使用哈希集合来存储字典方便查找
        HashSet<String> dict = new HashSet<>(wordDict);
        // dp[i]代表的是s[0,i-1]的子串能否被分割
        // 因此需要s.length + 1长度的boolean数组
        // 为了方便判断边界条件例如s本身就是合法，我们将dp[0]定义为合法，即为true
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=0; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(dp[j] && dict.contains(s.substring(j,i))){
                    // 如果子串能分割就定义为合法
                    // 注意substring的方法可以理解为前闭后开
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
