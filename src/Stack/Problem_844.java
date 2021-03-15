package Stack;

public class Problem_844 {
    class Solution {
        public boolean backspaceCompare(String S, String T) {
            return build(S).equals(build(T));
        }

        public String build(String s){
            StringBuilder sb = new StringBuilder();
            int length = s.length();
            for(int i=0; i<length; i++){
                char c = s.charAt(i);
                if(c != '#'){
                    sb.append(c);
                }else{
                    if(sb.length() > 0){
                        sb.deleteCharAt(sb.length() -1);
                    }
                }
            }
            return sb.toString();
        }
    }
}
