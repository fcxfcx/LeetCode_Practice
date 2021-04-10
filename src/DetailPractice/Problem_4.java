package DetailPractice;

/**
 * Problem 4. 寻找两个正序数组的中位数
 * 标签：数组，二分查找
 */
public class Problem_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 假设i对应划分线在nums1的右边那个数，j对应nums2中划分线右边的数
        // 为了之后枚举时保证在[0 , m]范围内取得的i必有对应的j，如果nums1的长度大于nums2，我们需要调换两者位置
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        // 划分出的左边数组长度，也就是i和j的和
        int totalLeft = (m + n + 1) / 2;
        int left = 0, right = m;
        // 从[0,m]区间开始枚举，寻找满足条件的划分，第一个条件是i和j的和等于totalLeft
        // 第二个条件是nums1[i-1] <= nums2[j] 以及 nums1[j-1] <= nums2[i]，即划分后左边数组的所有数要小于右边
        while (left < right) {
            // 使用中位数的方法去取i的值，注意+1是因为在else语句中left会取为i的值，如果是直接取中位数会导致死循环，因为永远小于right
            // 但是如果+1之后，除以2向下取整的结果是会大于right的
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                // 如果没有满足条件二，说明左边的数太大了，划分线需要向左侧调整
                // 这里的一个判断其实就否认了条件二的两个条件
                right = i - 1;
            } else {
                // 如果满足了条件二，
                left = i;
            }
        }
        // 取得了合适的划分线后开始判断极端情况
        int i = left;
        int j = totalLeft - left;
        // 这里的四个数对应的就是划分线左右的四个数，设定极端情况的最大值/最小值，避免它们在比较中被选中（因为是不存在这个数的）
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        // 判断整体数组的奇偶，返回对应的中位数
        if ((m + n) % 2 == 0) {
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }else{
            return Math.max(nums1LeftMax,nums2LeftMax);
        }
    }
}
