package Stack;

public class Problem_1544 {
    class Solution {
        public String makeGood(String s) {
            StringBuilder sb = new StringBuilder();
            if(s.length() <= 1){
                return s;
            }else{
                for(int i=0; i<s.length(); i++){
                    int top = sb.length();
                    char ch = s.charAt(i);
                    if(top == 0){
                        sb.append(ch);
                        continue;
                    }else if(sb.charAt(top-1)+32 == ch || sb.charAt(top-1)-32 == ch){
                        sb.deleteCharAt(top-1);
                    }else{
                        sb.append(ch);
                    }
                }
            }
            return sb.toString();
        }
    }
}
