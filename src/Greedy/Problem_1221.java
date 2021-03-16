package Greedy;

public class Problem_1221 {
    class Solution {
        public int balancedStringSplit(String s) {
            int flag= 0;
            int result = 0;
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c == 'R'){
                    flag += 1;
                }else{
                    flag -= 1;
                }
                if(flag == 0){
                    result += 1;
                }
            }
            return result;
        }
    }
}
