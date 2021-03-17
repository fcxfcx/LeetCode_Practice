package Greedy;

public class Problem_605 {
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int count = 0;
            int previous = -1;
            int length = flowerbed.length;
            for(int i=0; i<length; i++){
                if(flowerbed[i] == 1){
                    if(previous < 0){
                        count += i/2;
                    }else{
                        count += (i-previous-2)/2;                }
                    previous = i;
                }
            }
            if(previous < 0){
                count = (length+1)/2;
            }else{
                count += (length - previous -1)/2;
            }
            return count>=n?true:false;
        }
    }
}
