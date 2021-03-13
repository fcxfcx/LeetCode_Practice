package Stack;
import java.util.Stack;

public class Problem_682 {
    public int calPoints(String[] ops) {
        int total = 0;
        Stack<Integer> stack = new Stack<>();
        for(String s : ops){
            if(s.equals("C")){
                int temp = stack.pop();
                total = total - temp;
            }else if(s.equals("D")){
                int temp = stack.peek();
                stack.push(temp*2);
                total = total + temp*2;
            }else if(s.equals("+")){
                int top = stack.pop();
                int newTop = stack.peek();
                stack.push(top);
                stack.push(top+newTop);
                total = total + top + newTop;
            }else{
                int newOne = Integer.parseInt(s);
                stack.push(newOne);
                total = total + newOne;
            }
        }
        return total;
    }
}
