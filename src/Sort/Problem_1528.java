package Sort;

public class Problem_1528 {
    class Solution {
        public String restoreString(String s, int[] indices) {
            int length = s.length();
            char[] result = new char[length];
            for(int i=0; i<length; i++){
                result[indices[i]] = s.charAt(i);
            }
            return new String(result);
        }
    }
}
