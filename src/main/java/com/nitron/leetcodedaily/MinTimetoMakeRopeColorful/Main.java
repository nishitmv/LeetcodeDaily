package com.nitron.leetcodedaily.MinTimetoMakeRopeColorful;

public class Main {

    public static void main(String[] args) {

        String colors = "aabaa";
        int[] neededTime = {1,2,3,4,1};

        System.out.println(new MinTimeMakeRopeColorful().minCost(colors, neededTime));

    }

}
