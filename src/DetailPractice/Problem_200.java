package DetailPractice;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 200. 岛屿数量
 * 标签：深度优先搜索（此题还可以用并查集来做）
 */
public class Problem_200 {
    int row;
    int column;
    int count;

    public int numIslands(char[][] grid) {
        row = grid.length;
        column = grid[0].length;
        count = 0;
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // 开始深度优先搜索
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int n, int m) {
        // 如果触及到了边界，无论是地图的边界还是岛屿的边界，那么就返回
        if (n >= row || n < 0 || m < 0 || m >= column || grid[n][m] == '0') {
            return;
        }

        // 遍历到的点重置为0，避免再次遍历
        grid[n][m] = '0';
        dfs(grid, n - 1, m);
        dfs(grid, n + 1, m);
        dfs(grid, n, m - 1);
        dfs(grid, n, m + 1);
    }
}
