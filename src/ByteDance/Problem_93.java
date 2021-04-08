package ByteDance;

import java.util.*;

public class Problem_93 {
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            int len = s.length();
            if(len<4 || len>12){
                return res;
            }
            Deque<String> path = new LinkedList<>();
            dfs(path, s, len, 0, 0, res);
            return res;
        }

        public void dfs(Deque<String> path, String s, int len, int begin, int split, List<String> res){
            if (begin == len) {
                if (split == 4) {
                    res.add(String.join(".", path));
                }
                return;
            }

            // 看到剩下的不够了，就退出（剪枝），len - begin 表示剩余的还未分割的字符串的位数
            if (len - begin < (4 - split) || len - begin > 3 * (4 - split)) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                if (begin + i >= len) {
                    break;
                }

                int ipSegment = judge(s, begin, begin + i);
                if (ipSegment != -1) {
                    // 在判断是 ip 段的情况下，才去做截取
                    path.addLast(ipSegment + "");
                    dfs(path, s, len, begin + i + 1, split + 1, res);
                    path.removeLast();
                }
            }
        }

        private int judge(String ip, int left, int right){
            int len = right - left + 1;
            if(len > 1 && ip.charAt(left) == '0'){
                return -1;
            }
            int temp = 0;
            for (int i = left; i <= right; i++) {
                temp = temp * 10 + ip.charAt(i) - '0';
            }
            if(temp > 255){
                return -1;
            }
            return temp;
        }
    }
}
