package Offer;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 29. 顺时针打印矩阵
 * 标签：数组
 */
public class Offer_29 {
    public int[] spiralOrder(int[][] matrix) {
        // 使用模拟法进行遍历，direction存储四个遍历方向，遇到边界就转向
        // 时间复杂度为O(mn)，m，n分别为行数和列数，空间复杂度为O(1)
        int row = matrix.length;
        if(row == 0){
            return new int[0];
        }
        int column = matrix[0].length;
        int[] res = new int[row * column];
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        int r = 0, c = 0;
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row*column; i++) {
            res[i] = matrix[r][c];
            visited[r][c] = true;
            int nextR = r + direction[directionIndex][0];
            int nextC = c + direction[directionIndex][1];
            if (nextR < 0 || nextR >= row || nextC < 0 || nextC >= column || visited[nextR][nextC]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            r = r + direction[directionIndex][0];
            c = c + direction[directionIndex][1];
        }
        return res;
    }

    public int[] moreSimple(int[][] matrix){
        // 一种使用四个常数作为边界的写法
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }
        return res;
    }
}
