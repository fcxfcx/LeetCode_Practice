package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Problem_1710 {
    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes, new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    return b[1] - a[1];
                }
            });
            int result = 0;
            int currentSize = 0;
            for(int[] boxType : boxTypes){
                if(boxType[0] <= truckSize - currentSize){
                    result += boxType[0]*boxType[1];
                    currentSize += boxType[0];
                }else{
                    result += (truckSize-currentSize)*boxType[1];
                    break;
                }
            }
            return result;
        }
    }
}
