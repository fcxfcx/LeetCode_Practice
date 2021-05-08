package Offer;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 13. 机器人的运动范围
 * 标签：深度优先搜索
 */
public class Offer_13 {
    public int movingCount(int m, int n, int k) {
        // 这题和之前做的很多在matrix上的深度优先搜索类似，判断条件有些许不同
        // 时间复杂度为O(mn)，空间复杂度为O(mn)，主要体现在visited矩阵上
        boolean[][] visited = new boolean[m][n];
        return dfs(visited, m, n, 0, 0, k);
    }

    public int dfs(boolean[][] visited, int m, int n, int i, int j, int k) {
        // 注意边界情况
        if (i >= m || i < 0 || j >= n || j < 0 || visited[i][j] || (i / 10 + i % 10 + j / 10 + j % 10) > k) {
            return 0;
        }
        visited[i][j] = true;
        // 注意最后要假1
        return dfs(visited, m, n, i + 1, j, k) + dfs(visited, m, n, i - 1, j, k) + dfs(visited, m, n, i, j + 1, k) + dfs(visited, m, n, i, j - 1, k) + 1;
    }
}
