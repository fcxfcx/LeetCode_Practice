package DetailPractice;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 238. 除自身以外数组的乘积
 * 标签：数组，前后缀法
 */
public class Problem_238 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        // 储存结果集
        int[] answer = new int[length];
        // 第一个数的前缀一定是1，因为不存在其他数
        answer[0] = 1;
        // 首先遍历获取前缀集（即数左边所有数的乘积），存放于answer中
        for (int i = 1; i < length; i++) {
            answer[i] = answer[i - 1] * nums[i-1];
        }
        // 后缀集的最后一个一定是1，因为不存在其他数
        int R = 1;
        // 倒序遍历后缀集（即数右边的所有数的乘积），并且更新结果集
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            // 维护后缀集的数，避免使用两个数组
            R = R * nums[i];
        }
        return answer;
    }
}
