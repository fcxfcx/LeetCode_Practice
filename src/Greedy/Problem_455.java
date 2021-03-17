package Greedy;

import java.util.Arrays;

public class Problem_455 {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            int satisfy = 0;
            int current = 0;
            Arrays.sort(s);
            Arrays.sort(g);
            for(int i=0; i<g.length; i++){
                int temp = g[i];
                for(int j=current; j<s.length; j++){
                    if(s[j] >= temp){
                        satisfy += 1;
                        current += 1;
                        break;
                    }else{
                        current += 1;
                    }
                }
            }
            return satisfy;
        }
    }
}
