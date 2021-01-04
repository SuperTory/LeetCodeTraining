public class NumOfIsland200 {
    boolean[][] markArr;
    char[][] gridMap;
    public int numIslands(char[][] grid) {
        gridMap=grid;
        markArr=new boolean[grid.length][grid[0].length];
        int markNum=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!markArr[i][j]&&gridMap[i][j]=='1'){
                    markNum++;
                    markIsland(i,j);
                }
            }
        }
        return markNum;

    }

    void markIsland(int i,int j){
        if (!markArr[i][j]&&gridMap[i][j]=='1') {
            markArr[i][j] = true;
            if (i - 1 >= 0)
                markIsland(i - 1, j);
            if (i + 1 < markArr.length)
                markIsland(i + 1, j);
            if (j - 1 >= 0)
                markIsland(i, j - 1);
            if (j + 1 < markArr[0].length)
                markIsland(i, j + 1);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[4][];
        grid[0]=new char[]{'1','1','1','1','0'};
        grid[1]=new char[]{'1','1','0','1','0'};
        grid[2]=new char[]{'1','1','0','0','0'};
        grid[3]=new char[]{'0','0','0','0','0'};

        NumOfIsland200 n=new NumOfIsland200();
        System.out.println(n.numIslands(grid));
    }
}
