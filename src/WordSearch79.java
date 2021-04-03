public class WordSearch79 {
    boolean[][] visited;    //用于标记是否遍历过

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag = visit(board, i, j, word.toCharArray(), 0);
                if (flag)
                    return true;
            }
        }
        return false;
    }

    private boolean visit(char[][] board, int x, int y, char[] word, int index) {
        if (index == word.length)   //检索完整个字符串，匹配成功
            return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length)    //坐标越界
            return false;
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        if (board[x][y] == word[index] && !visited[x][y]) { //若字符匹配并且未遍历过
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                boolean flag = visit(board, x + move[i][0], y + move[i][1], word, index + 1);
                if (flag)
                    return true;
            }
            visited[x][y] = false;     //回溯时取消遍历标记
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        WordSearch79 w = new WordSearch79();
        boolean res = w.exist(board, "ABCB");
        System.out.println(res);
    }
}
