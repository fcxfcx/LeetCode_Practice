package Offer;

import jdk.nashorn.internal.ir.ReturnNode;

import java.util.*;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 3.数组中重复的数字
 * 标签：数组，哈希表
 */
public class Offer_3 {
    public int findRepeatNumber_1(int[] nums) {
        // 方法1，通过哈希储存每个数的个数，时间复杂度和空间复杂度都为O(n)
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int num : nums) {
           if(!set.add(num)){
               repeat = num;
               break;
           }
        }
        return repeat;
    }

    public int findRepeatNumber_2(int[] nums){
        // 方法2，原地交换，优化空间复杂度至O(1)，时间复杂度为O(n)
        // 思路是将数值与数组索引对应，采取交换的方式，如果某次对应发现该索引上的数等于当前数值，则说明该数重复
        int index = 0;
        while(index < nums.length){
            if(nums[index] == index){
                // 已经相等的位置不用交换
                index ++;
                continue;
            }
            if(nums[nums[index]] == nums[index]){
                // 如果目标索引上的数等于当前数值，则说明重复
                return nums[index];
            }
            int temp = nums[nums[index]];
            nums[nums[index]] = nums[index];
            nums[index] = temp;
        }
        return -1;
    }
}
