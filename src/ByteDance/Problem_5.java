package ByteDance;

public class Problem_5 {
    class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            if(len < 2){
                return s;
            }
            int maxLen = 1;
            int beginIndex = 0;
            boolean[][] dp = new boolean[len][len];
            for(int i=0; i<len; i++){
                dp[i][i] = true;
            }
            for(int j=1; j<len; j++){
                for(int i=0; i<j; i++){
                    if(s.charAt(j) == s.charAt(i)){
                        if(j-i<3){
                            dp[i][j] = true;
                        }else{
                            dp[i][j] = dp[i+1][j-1];
                        }
                    }
                    if(dp[i][j] && j-i+1>maxLen){
                        maxLen = j-i+1;
                        beginIndex = i;
                    }
                }
            }
            return s.substring(beginIndex,beginIndex+maxLen);
        }
    }
}
