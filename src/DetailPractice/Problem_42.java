package DetailPractice;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 42. 接雨水
 * 标签：动态规划
 */
public class Problem_42 {
    public int trap(int[] height) {
        int length = height.length;
        // 分别储存最后答案，从左向右看最高值，从右向左看的最高值
        int ans = 0;
        int[] leftMaxHeight = new int[length];
        int[] rightMaxHeight = new int[length];
        if(length < 2){
            return ans;
        }
        // 初始化左端最高值的数组，并遍历获取每个点的左端最高值
        leftMaxHeight[0] = height[0];
        for(int i=1; i<length; i++){
            leftMaxHeight[i] = Math.max(leftMaxHeight[i-1], height[i]);
        }
        // 初始化左端最高值的数组，并遍历获取每个点的左端最高值
        rightMaxHeight[length-1] = height[length-1];
        for(int i=length-2; i>=0; i--){
            rightMaxHeight[i] = Math.max(rightMaxHeight[i-1], height[i]);
        }
        // 每个点的积水量等于左右最高值的较小值减去当前点的高度
        for(int i=0; i<length; i++){
            ans += Math.min(leftMaxHeight[i],rightMaxHeight[i])-height[i];
        }
        return ans;
    }
}
