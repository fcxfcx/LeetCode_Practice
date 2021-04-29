package Offer;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 11. 旋转数组的最小值
 * 标签：二分搜索
 */
public class Offer_11 {
    public int minArray(int[] numbers) {
        // 使用二分法查找，可以将时间复杂度优化成O(log n)，空间复杂度O(1)
        int i=0;
        int j=numbers.length -1;
        while(i < j){
            int mid = (j+i)/2;
            if(numbers[mid] > numbers[j]){
                // 如果中间数大于最右边的数，说明最小值在右边
                i = mid+1;
            }else if(numbers[mid] < numbers[j]){
                // 如果中间数小于最右边的数，说明最小值在左边
                j = mid;
            }else{
                // 如果中间数等于最右边的数，则判断不了最小值
                j--;
            }
        }
        return numbers[i];
    }
}
