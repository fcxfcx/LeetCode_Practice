package Sort;

public class Problem_912 {
    //根据要求此题使用二分选择排序方法
    class Solution {
        public int[] sortArray(int[] nums) {
            int length = nums.length;
            for(int i=0; i<length/2; i++){
                int minIndex = i;
                int maxIndex = i;
                for(int j=i+1; j<length-i; j++){
                    if(nums[j] < nums[minIndex]){
                        minIndex = j;
                    }
                    if(nums[j] > nums[maxIndex]){
                        maxIndex = j;
                    }
                }
                if(maxIndex == minIndex) break;
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
                if(maxIndex == i) maxIndex = minIndex;
                temp = nums[length-i-1];
                nums[length-i-1] = nums[maxIndex];
                nums[maxIndex] = temp;
            }
            return nums;
        }
    }
}
