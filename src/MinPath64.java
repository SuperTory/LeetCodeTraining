public class MinPath64 {
    int gridLength, gridWidth;

    public int minPathSum(int[][] grid) {
        gridLength = grid[0].length;
        gridWidth = grid.length;
        return move(grid, 0, 0, 0);
    }

    private int move(int[][] grid, int x, int y, int total) {
        if (x == gridWidth - 1 && y == gridLength - 1)
            return total + grid[x][y];
        int down = 999, right = 999;
        if (x < gridWidth - 1)
            down = move(grid, x + 1, y, total + grid[x][y]);
        if (y < gridLength - 1) {
            right = move(grid, x, y + 1, total + grid[x][y]);
        }
        return Math.min(down, right);
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinPath64 m = new MinPath64();
        m.minPathSum(grid);

    }
}
