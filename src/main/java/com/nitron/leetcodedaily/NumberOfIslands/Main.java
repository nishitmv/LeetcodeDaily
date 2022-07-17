package com.nitron.leetcodedaily.NumberOfIslands;

public class Main {

    public static void main(String[] args) {

        char[][] grid = {{'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}};
        
        char[][] grid2 = {  {'1','1','1','1','0'},
                            {'1','1','0','1','0'},
                            {'1','1','0','0','0'},
                            {'0','0','0','0','0'}};

        char[][] grid3 = {{'1'},{'1'}};
        char[][] grid4 = {{'1'}};
        char[][] grid5 = {{'1','0','1','1','0','1','1'}};
        
        System.out.println(new NumOfIslandsFloodFill().countIslands(grid5));

    }

}
