package Greedy;

import java.util.Arrays;

public class Problem_1005 {
    class Solution {
        public int largestSumAfterKNegations(int[] A, int K) {
            int result = 0;
            Arrays.sort(A);
            for(int i=0; i<K; i++){
                if(A[i] < 0){
                    A[i] = -A[i];
                }else if(A[i] == 0){
                    break;
                }else{
                    if((K-i) % 2 == 0){
                        break;
                    }else if(i==0 || A[i] < A[i-1]){
                        A[i] = -A[i];
                    }else{
                        A[i-1] = -A[i-1];
                    }
                }
            }
            for(int a : A){
                result += a;
            }
            return result;
        }
    }
}
