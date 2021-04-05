public class LC695IslandArea {
    int m, n;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0)
            return 0;
        int area = 1;
        grid[i][j] = 0;     //将遍历过的点置为0
        for (int[] d : directions)
            area += dfs(grid, i + d[0], j + d[1]);  //通过递归调用进行深度优先遍历

        return area;
    }
}



