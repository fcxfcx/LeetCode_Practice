package Sort;

public class Problem_1370 {
    class Solution {
        public String sortString(String s) {
            int[] nums = new int[26];
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                nums[s.charAt(i)-'a'] ++;
            }
            while(sb.length() < s.length()){
                for(int j=0; j<26; j++){
                    if(nums[j] != 0){
                        nums[j] --;
                        sb.append((char)(j+'a'));
                    }
                }
                for(int k=25; k>=0; k--){
                    if(nums[k] != 0){
                        nums[k] --;
                        sb.append((char)(k+'a'));
                    }
                }
            }
            return sb.toString();
        }
    }
}
