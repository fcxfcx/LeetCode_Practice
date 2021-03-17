package Greedy;

public class Problem__1736 {
    class Solution {
        public String maximumTime(String time) {
            StringBuilder sb = new StringBuilder();
            char one = time.charAt(0);
            char two = time.charAt(1);
            char three = time.charAt(3);
            char four = time.charAt(4);
            if(one == '?'){
                if(two == '?'){
                    sb.append("23:");
                }else if(two < '4'){
                    sb.append("2");
                    sb.append(two);
                    sb.append(":");
                }else{
                    sb.append("1");
                    sb.append(two);
                    sb.append(":");
                }
            }else{
                if(two == '?' && one == '2'){
                    sb.append("23:");
                }else if(two != '?'){
                    sb.append(one);
                    sb.append(two);
                    sb.append(":");
                }else{
                    sb.append(one);
                    sb.append("9:");
                }
            }
            if(three == '?'){
                if(four == '?'){
                    sb.append("59");
                }else{
                    sb.append("5");
                    sb.append(four);
                }
            }else{
                if(four == '?'){
                    sb.append(three);
                    sb.append("9");
                }else{
                    sb.append(three);
                    sb.append(four);
                }
            }
            return sb.toString();
        }
    }
}
