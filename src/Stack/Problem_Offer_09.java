package Stack;
import java.util.Stack;

public class Problem_Offer_09 {
    Stack<Integer> appendStack;
    Stack<Integer> deleteStack;

    public Problem_Offer_09() {
        appendStack = new Stack<>();
        deleteStack = new Stack<>();
    }

    public void appendTail(int value) {
        appendStack.push(value);
    }

    public int deleteHead() {
        if(deleteStack.isEmpty()){
            if(appendStack.isEmpty()){
                return -1;
            }
            while(!appendStack.isEmpty()){
                deleteStack.push(appendStack.pop());
            }
        }
        return deleteStack.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
