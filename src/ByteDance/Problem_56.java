package ByteDance;
import java.util.*;

public class Problem_56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[0][2];
            }
            Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
            List<int[]> res = new ArrayList<>();
            for (int i = 0; i < intervals.length; i++) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                if (res.size() == 0 || res.get(res.size() - 1)[1] < left) {
                    res.add(new int[]{left, right});
                } else {
                    res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], right);
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
}
