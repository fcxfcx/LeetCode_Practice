package Sort;

import java.util.Arrays;
import java.util.HashMap;

public class Problem_506 {
    class Solution {
        public String[] findRelativeRanks(int[] score) {
            int[] arr = score.clone();
            int length = score.length;
            Arrays.sort(score);
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=0; i<length; i++){
                map.put(score[i],length-i);
            }
            String[] ret = new String[length];
            for(int i=0; i<length; i++){
                if(arr[i] == score[length-1]) ret[i] = "Gold Medal";
                else if(arr[i] == score[length-2]) ret[i] = "Silver Medal";
                else if(arr[i] == score[length-3]) ret[i] = "Bronze Medal";
                else{
                    ret[i] = String.valueOf(map.get(arr[i]));
                }
            }
            return ret;
        }
    }
}
