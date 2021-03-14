package Stack;
import java.util.Stack;
import java.util.HashMap;

public class Problem_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                hashMap.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while(!stack.isEmpty()){
            hashMap.put(stack.pop(),-1);
        }
        for(int j=0; j<nums1.length; j++){
            result[j] = hashMap.get(nums1[j]);
        }
        return result;
    }
}
