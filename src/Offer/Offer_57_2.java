package Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 57.2. 和为s的连续正数序列
 */
public class Offer_57_2 {
    public int[][] findContinuousSequence(int target) {
        // 使用滑动窗口，当窗口内和小于target则右边界右移，若大于target则左边界右移
        // 如果等于target则记录从下一个数开始滑动
        // 时间复杂度为O(n)，空间复杂度O(1)
        // 这里用LinkedList会比ArrayList快约一毫秒，因为全是写操作
        List<int[]> list = new LinkedList<>();
        int i = 1, j = 1;
        int sum = 0;
        while (i <= target / 2) {
            if (sum < target) {
                sum += j;
                j++;
            } else if (sum > target) {
                sum -= i;
                i++;
            }else{
                int[] arr = new int[j-i];
                for(int k=i; k<j; k++){
                    arr[k-i] = k;
                }
                list.add(arr);
                sum -= i;
                i++;
            }
        }
        return list.toArray(new int[list.size()][] );
    }
}
