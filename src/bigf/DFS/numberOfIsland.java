package bigf.DFS;

import bigf.LinkedList.ListNode;

public class numberOfIsland {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfsFill(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfsFill(char[][] grid, int i, int j) {
        if(i >= 0 && j >= 0 && i <= grid.length && j <= grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            dfsFill(grid, i + 1, j);
            dfsFill(grid, i - 1, j);
            dfsFill(grid, i, j + 1);
            dfsFill(grid, i, j - 1);
        }
    }

    private void bfsFill(char[][] grid, int i, int j) {
        grid[i][j]='0';
        int n = grid.length;
        int m = grid[0].length;

    }
}
