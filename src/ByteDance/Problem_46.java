package ByteDance;

import java.util.*;

public class Problem_46 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }
            Deque<Integer> path = new LinkedList();
            boolean[] used = new boolean[len];
            dfs(nums, len, 0, res, path, used);
            return res;
        }

        private void dfs(int[] nums, int len, int index, List<List<Integer>> res, Deque<Integer> path, boolean[] used) {
            if (len == index) {
                res.add(new ArrayList(path));
                return;
            }
            for (int i = 0; i < len; i++) {
                if (used[i] == false) {
                    path.addLast(nums[i]);
                    used[i] = true;

                    dfs(nums, len, index + 1, res, path, used);

                    used[i] = false;
                    path.removeLast();
                }
            }
        }
    }
}
