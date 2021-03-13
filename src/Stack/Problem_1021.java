package Stack;

import java.util.Stack;

/**
 *1021. 删除最外层的括号
 */
public class Problem_1021 {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == '('){
                stack.push('(');
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    sb.append(S.substring(start+1,i));
                    start = i + 1;
                }
            }
        }
        return sb.toString();
    }
}
