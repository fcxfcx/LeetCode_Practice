package ByteDance;

public class Problem_11 {
    class Solution {
        public int maxArea(int[] height) {
            int length = height.length;
            int left = 0, right = length - 1;
            int area = 0;
            while (left < right) {
                int leftHeight = height[left];
                int rightHeight = height[right];
                int newArea = Math.min(leftHeight, rightHeight) * (right - left);
                area = Math.max(area, newArea);
                if (leftHeight < rightHeight) {
                    left++;
                } else {
                    right--;
                }
            }
            return area;
        }
    }
}
