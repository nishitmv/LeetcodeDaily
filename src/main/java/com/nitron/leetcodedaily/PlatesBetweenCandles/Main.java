package com.nitron.leetcodedaily.PlatesBetweenCandles;

public class Main {

    public static void main(String[] args) {

        String s = "*|*||||**|||||||*||*||*||**|*|*||*";
        int[][] queries = {{2,33},{2,32},{3,31},{0,33},{1,24},{3,20},{7,11},{5,32},{2,31},{5,31},{0,31},{3,28},{4,33},{6,29},{2,30},{2,28},{1,30},{1,33},{4,32},{5,30},{4,23},{0,30},{3,10},{5,28},{0,28},{4,28},{3,33},{0,27}};

        for (int i : new PlatesBetweenCandlesTreeMapFullRange().platesBetweenCandles(s, queries)) {
            System.out.println(i);
        }

    }

}
