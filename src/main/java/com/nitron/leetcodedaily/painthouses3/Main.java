package com.nitron.leetcodedaily.painthouses3;

public class Main {
    public static void main(String[] args) {
       // int[] houses = {0,0,0,0,0};
        //int[][] cost = {{1,10},{10,1},{10,1},{1,10},{5,1}};
       // int m = 5, n = 2, target = 3;

        int[] houses = {0,2,1,2,0};
        int[][] cost = {{1,10},{10,1},{10,1},{1,10},{5,1}};
        int m = 5,  n = 2, target = 3;

        System.out.println(new PaintHouses().calcMinCost(houses, cost, m, n, target));

    }

}
