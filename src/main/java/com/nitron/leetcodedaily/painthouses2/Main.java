package com.nitron.leetcodedaily.painthouses2;

public class Main {

    public static void main(String[] args) {
        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        int[][] costs2 = {{7,6,2}};
        int[][] costs3 = {{17,7,13},{8,14,4},{13,20,16},{3,2,15},{11,17,19},{18,2,3}};

        System.out.println(new PaintHouses().calcMinCost(costs3));
    }
}
