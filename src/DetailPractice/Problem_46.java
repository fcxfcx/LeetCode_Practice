package DetailPractice;

import java.util.*;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 46. 全排列
 * 标签：回溯算法
 */
public class Problem_46 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }
        Deque<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[len];
        dfs(nums,0,len,res,path,used);
        return res;
    }

    /**
     * 使用回溯算法向下搜索数组
     * @param nums 提供的数组
     * @param index 当前填入第几个数
     * @param len 总共需要几个数
     * @param res 最终返回的答案（所有组合情况）
     * @param path 当前的组合
     * @param used 已经使用过的数
     */
    public void dfs (int[] nums, int index, int len, List<List<Integer>> res, Deque<Integer> path, boolean[] used){
        if(index == len){
            // 如果已经填满了所有数，则记录当前的组合至答案并返回（回溯）
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0; i<len; i++){
            if(!used[i]){
                // 尝试添加每一种未使用的数
                path.addLast(nums[i]);
                used[i] = true;
                // 添加后继续向下搜索可能的组合
                dfs(nums, index+1, len, res, path, used);
                // 在回溯之后，将当前数重置为未使用，将当前组合重置为上一次的状态，并进行下一次循环
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
