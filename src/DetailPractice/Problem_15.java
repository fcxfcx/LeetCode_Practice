package DetailPractice;

import java.util.*;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 15. 三数之和
 * 标签：数组，双指针
 */
public class Problem_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int len = nums.length;
        // 特判
        if(len < 3){
            return ret;
        }
        // 首先排序，减小循环时的时间复杂度
        Arrays.sort(nums);
        // 开始枚举第一个数
        for(int first=0; first<len; first++){
            // 如果和上一个数相同则跳过
            if(first > 0 && nums[first-1] == nums[first]){
                continue;
            }
            // 第三个数从最大值开始枚举，每次循环第一个数时维护
            int third = len - 1;
            // 记录其他两数的和
            int target = -nums[first];
            // 开始枚举第二个数
            for(int second = first+1; second<len; second++){
                // 如果和上一个数相同则跳过
                if(second>first+1 && nums[second-1] == nums[second]){
                    continue;
                }
                // 枚举第三个数
                while(second < third && nums[second]+nums[third]>target){
                    third--;
                }
                // 如果指针重合，随着第二个数（b）后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if(second == third){
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ret.add(list);
                }
            }
        }
        return ret;
    }
}
