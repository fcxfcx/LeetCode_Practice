package DetailPractice;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 33. 搜索旋转排序数组
 * 标签：二分搜索
 */
public class Problem_33 {
    public int search(int[] nums, int target){
        int len = nums.length;
        if(len < 1){
            return -1;
        }
        if(len == 1){
            return nums[0]==target ? 0 : -1;
        }
        // 定义左边界和右边界
        int l=0, r=len-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[0] <= nums[mid]){
                // 如果左边的子数组有序
                if(nums[0] <= target && target < nums[mid]){
                    // 如果target在左边子数组之间则移动右边界
                    r = mid-1;
                }else{
                    // 否则就移动左边界
                    l = mid+1;
                }
            }else{

                // 如果右边的子数组有序
                if(nums[mid] < target && target <= nums[len-1]){
                    // 如果target在右边子数组之间则移动左边界
                    l = mid + 1;
                }else{
                    // 否则就移动右边界
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
