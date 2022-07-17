package com.nitron.leetcodedaily.NumberOfIslands;

public class NumOfIslandsFloodFill {
    public int countIslands(char[][] grid) {

        if(grid.length ==0)
            return 0;

        int count =0;

        for(int i=0;i<grid.length; i++)
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] =='1') {
                    dfsFloodFill(grid, i, j);
                    count++;
                }
            }

        return count;
    }

    private void dfsFloodFill(char[][] grid, int i, int j) {

        if(i>=0 && j>=0 && i< grid.length && j<grid[0].length && grid[i][j] =='1')
        {
            grid[i][j] ='0';

            dfsFloodFill(grid, i-1, j);
            dfsFloodFill(grid, i, j-1);
            dfsFloodFill(grid, i+1, j);
            dfsFloodFill(grid, i, j+1);

        }


    }
}
