package ByteDance;

public class Problem_33 {
    class Solution {
        public int search(int[] nums, int target) {
            int len = nums.length;
            if (len == 0) {
                return -1;
            }
            if (len == 1) {
                return target == nums[0] ? 0 : -1;
            }
            int left = 0;
            int right = len - 1;
            while (left <= right) {
                int mid = (right + left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < nums[right]) {
                    // 右边有序的情况
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    // 左边有序的情况
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            return -1;
        }
    }
}
