package com.nitron.leetcodedaily.MaxAreaOfIsland;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {

        if(grid.length ==0)
            return 0;
        int maxArea = 0;

        for(int i =0; i<grid.length;i++)
            for(int j=0; j<grid[0].length;j++)
            {
                if(grid[i][j] ==1)
                {

                   int  area = dfsFloodFill(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }


        return maxArea;
    }

    private int dfsFloodFill(int[][] grid, int i, int j) {

        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1+(dfsFloodFill(grid, i + 1, j)+
            dfsFloodFill(grid, i - 1, j)+
            dfsFloodFill(grid, i, j - 1)+
            dfsFloodFill(grid, i, j + 1));

        }


        return 0;
    }
}
