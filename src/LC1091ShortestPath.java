import java.util.LinkedList;
import java.util.Queue;

public class LC1091ShortestPath {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (n == 0) return -1;

        int[][] directions = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int pathLen = 0;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();  //记录这一层节点数，pathLen按层增加
            pathLen++;
            while (size-- > 0) {
                Integer[] current = queue.poll();
                int curX = current[0], curY = current[1];
                if (grid[curX][curY] == 1) //此路不通
                    continue;
                if (curX == n - 1 && curY == n - 1)   //已到终点
                    return pathLen;
                for (int[] dirc : directions) {     //按各方向扩展节点
                    int nextX = curX + dirc[0], nextY = curY + dirc[1];
                    if (0 <= nextX && nextX < n && 0 <= nextY && nextY < n) {
                        queue.offer(new Integer[]{nextX, nextY});
                    }
                }
                grid[curX][curY] = 1;     //注意将遍历过的节点置为1防止重复遍历
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC1091ShortestPath s = new LC1091ShortestPath();
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 1}};
        int res = s.shortestPathBinaryMatrix(grid);
        System.out.println(res);
    }
}
