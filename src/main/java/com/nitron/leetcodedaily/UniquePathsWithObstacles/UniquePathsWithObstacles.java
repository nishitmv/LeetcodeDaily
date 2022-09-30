package com.nitron.leetcodedaily.UniquePathsWithObstacles;

public class UniquePathsWithObstacles {

    public static void main(String[] args) {

        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};

        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles(obstacleGrid));
    }

    Integer[][] matrix ;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        matrix = new Integer[m+1][n+1];

        return countUniquePaths(obstacleGrid, m-1, n-1);


    }

    private int countUniquePaths(int[][] obstacleGrid, int m, int n) {

        if(matrix[m][n]!=null)
            return matrix[m][n];

        if(obstacleGrid[m][n] ==1)
            return 0;
        if(m==0 && n==0)
            return 1;
        int count1 = 0;
        int count2 = 0;
        if(n>0 )
            count1 =  countUniquePaths(obstacleGrid, m, n-1);
        if(m>0)
            count2 = countUniquePaths(obstacleGrid, m-1, n);

        return matrix[m][n] = count1+count2;

    }
}
