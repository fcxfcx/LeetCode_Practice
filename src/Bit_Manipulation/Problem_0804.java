package Bit_Manipulation;

import java.util.ArrayList;
import java.util.List;

public class Problem_0804 {
    //使用递归
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<Integer>());
        newSubsets(ret, 0, nums);
        return ret;
    }

    public void newSubsets(List<List<Integer>> lists, int i, int[] nums){
        if(i == nums.length) return;
        List<List<Integer>> newLists = new ArrayList<>(lists);
        for(List<Integer> E : newLists){
            List<Integer> temp = new ArrayList<Integer>(E);
            temp.add(nums[i]);
            lists.add(temp);
        }
        newSubsets(lists, i+1, nums);;
    }

    class Bit{
        //使用位运算
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            //一共有nums长度的平方种组合，用位运算来处理
            int length = 1 << nums.length;
            for(int i=0; i<length; i++){
                List<Integer> list = new ArrayList<>();
                for(int j=0; j<nums.length; j++){
                    //如果数字i的某一个位置是1，就把数组中对应的数字添加到集合
                    if(((i >> j) & 1) == 1){
                        list.add(nums[j]);
                    }
                }
                ret.add(list);
            }
            return ret;
        }
    }
}
