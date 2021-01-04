import java.util.Queue;

public class MinPath64 {
//    int gridLength, gridWidth, minPath;

//    public int minPathSumOld(int[][] grid) {
//        gridLength = grid[0].length;
//        gridWidth = grid.length;
//        minPath = 999;
//        move(grid, 0, 0, 0);
//        return minPath;
//    }
//
//    private void move(int[][] grid, int x, int y, int total) {
//        if (x == gridWidth - 1 && y == gridLength - 1)
//            minPath = Math.min(minPath, total + grid[x][y]);
//        //深度优先搜索，通过与当前最小值比较进行剪枝，防止展开过多无用节点
//        if (x < gridWidth - 1 && total < minPath)   //向下移动
//            move(grid, x + 1, y, total + grid[x][y]);
//        if (y < gridLength - 1 && total < minPath)  //向右移动
//            move(grid, x, y + 1, total + grid[x][y]);
//    }

    public static void main(String[] args) {

        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinPath64 m = new MinPath64();
        System.out.println(m.minPathSum(grid));

    }

    public int minPathSum(int[][] grid) {
        int width = grid[0].length, high = grid.length;
        if (high == 0 || width == 0) return 0;
        // 初始化边缘的位置，在边缘沿直线走是最近的
        for (int i = 1; i < high; i++) grid[i][0] += grid[i - 1][0];
        for (int i = 1; i < width; i++) grid[0][i] += grid[0][i - 1];

        //动态规划，要求到当前位置的最短路径，即比较左边和上边到当前路径中最短的即可
        for (int i = 1; i < high; i++)
            for (int j = 1; j < width; j++)
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
        return grid[high - 1][width - 1];
    }
}
