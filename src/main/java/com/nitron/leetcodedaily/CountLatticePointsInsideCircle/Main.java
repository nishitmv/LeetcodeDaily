package com.nitron.leetcodedaily.CountLatticePointsInsideCircle;

public class Main {

    public static void main(String[] args) {

        int[][] circles = {{2,2,2},{3,4,1}};
        int[][] circles2 ={{2,2,1}};
        int[][] circles3 = {{8,9,6},{9,8,4},{4,1,1},{8,5,1},{6,7,5},{7,1,1},{5,5,3}};
        System.out.println(new CountLatticePointsInCircle().count(circles3));

    }

}
