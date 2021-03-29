package ByteDance;

import java.util.HashSet;

public class Probelm_3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashSet<Character> set = new HashSet<Character>();
            int answer = 0;
            int rightStart = -1;
            if(s.length() == 0){
                return 0;
            }
            for (int i=0; i<s.length(); i++){
                if(i != 0){
                    set.remove(s.charAt(i-1));
                }
                while(rightStart + 1<s.length() && !set.contains(s.charAt(rightStart+1))){
                    set.add(s.charAt(rightStart+1));
                    rightStart++;
                }
                answer = Math.max(answer, rightStart-i+1);
            }
            return answer;
        }
    }
}
