package Sort;

public class Problem_283 {
    //这道题按要求使用了冒泡排序去写
    class Solution {
        public void moveZeroes(int[] nums) {
            boolean swapped = true;
            int IndexOfLastUnsortted = nums.length-1;
            int swappedIndex = -1;
            while(swapped){
                swapped = false;
                for(int i=0; i<IndexOfLastUnsortted; i++){
                    if(nums[i] == 0){
                        nums[i+1] = nums[i+1] + nums[i];
                        nums[i] = nums[i+1] - nums[i];
                        nums[i+1] = nums[i+1] - nums[i];
                        swapped = true;
                        swappedIndex = i;
                    }
                }
                IndexOfLastUnsortted = swappedIndex;
            }
        }
    }
}
