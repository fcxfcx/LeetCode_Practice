package ByteDance;

public class Problem_31 {
    class Solution {
        public void nextPermutation(int[] nums) {
            int length = nums.length;
            int i = length - 2;
            while(i>=0 && nums[i] >= nums[i+1]){
                i--;
            }
            if(i>=0){
                int j = length - 1;
                while(j > i && nums[j] <= nums[i]){
                    j--;
                }
                swap(nums, i ,j);
                reverse(nums, i+1);
            }else{
                reverse(nums, 0);
            }
        }

        public void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void reverse(int[] nums, int start){
            int left = start;
            int right = nums.length - 1;
            while(left < right){
                swap(nums, left, right);
                left ++;
                right --;
            }
        }
    }
}
