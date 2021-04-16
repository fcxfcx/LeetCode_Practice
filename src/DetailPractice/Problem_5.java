package DetailPractice;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 5. 最长回文字串
 * 标签：动态规划
 */
public class Problem_5 {
    public String longestPalindrome(String s){
        int len = s.length();
        if(len < 2){
            // 特判，如果s的长度为1或者0那么肯定是回文
            return s;
        }
        // 用来存储最长字串的长度和起始index
        int maxLen = 1;
        int beginIndex = 0;
        // dp[i][j]代表从i到j的字串是否是回文串
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i<len; i++){
            // 每个数自己肯定是回文串
            dp[i][i] = true;
        }
        // 判断一串子串是否是回文的思路是从中心向两边伸展，如果一个回文串的两边字符相同则新的子串一定是回文串
        // 这里同样存在特判，即i到j的子串本身就只有两个数或者三个数，那么肯定是回文的
        for(int j=1; j<len; j++){
            for(int i=0; i<j; i++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                // 如果当前的子串是回文串而且长于目前的最大子串，则更新最大子串信息
                if(dp[i][j] && j-i+1>maxLen){
                    maxLen = j-i+1;
                    beginIndex = i;
                }
            }
        }
        return s.substring(beginIndex,beginIndex+maxLen);
    }
}
