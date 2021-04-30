package Offer;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 4. 二维数组中的查找
 * 标签：二分搜索
 */
public class Offer_4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 如果把矩阵向左旋转可以发现其性质和二分搜索树一致
        // 我们从右上角开始二分搜索，时间复杂度可以控制在O(m+n)，空间复杂度为O(1)
        // 这里我们走左子树的路线可以看作减少列数，走右子树的路线可以看作增大行数
        if(matrix == null || matrix.length < 1){
            return false;
        }
        int row = 0;
        int column = matrix[0].length-1;
        while(row < matrix.length && column >= 0){
            if(matrix[row][column] > target){
                 column--;
            }else if(matrix[row][column] < target){
                row++;
            }else{
                return  true;
            }
        }
        return false;
    }
}
