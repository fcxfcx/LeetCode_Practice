package ByteDance;

import java.util.*;

public class Problem_54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            List<Integer> ret = new ArrayList<>();
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int directionIndex = 0;
            int row = 0;
            int column = 0;
            for (int i = 0; i < m * n; i++) {
                ret.add(matrix[row][column]);
                matrix[row][column] = 0;
                int nextRow = row + directions[directionIndex][0];
                int nextColumn = column + directions[directionIndex][1];
                if (nextRow < 0 || nextRow >= m || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] == 0) {
                    directionIndex = (directionIndex + 1) % 4;
                }
                row = row + directions[directionIndex][0];
                column = column + directions[directionIndex][1];
            }
            return ret;
        }
    }
}
