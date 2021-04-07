package ByteDance;

import java.util.*;

public class Problem_22 {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n < 1) {
                return res;
            }
            dfs("", 0, 0, n, res);
            return res;
        }

        /**
         * @param curString 当前递归得到的结果
         * @param left   左括号已经用了几个
         * @param right  右括号已经用了几个
         * @param n      左括号、右括号一共得用几个
         * @param res    结果集
         */
        public void dfs(String curString, int left, int right, int n, List<String> res) {
            if (left == n && right == n) {
                res.add(curString);
                return;
            }
            // 剪枝
            if (left < right) {
                return;
            }
            if (left < n) {
                dfs(curString + "(", left + 1, right, n, res);
            }
            if (right < n) {
                dfs(curString + ")", left, right + 1, n, res);
            }
        }
    }
}
