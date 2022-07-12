package com.nitron.leetcodedaily.MatchsticksToSquare;

public class Main {

    public static void main(String[] args) {
        int[] matchsticks = {5,5,5,5,4,4,4,4,3,3,3,3};
        int[] matchsticks2 = {10,6,5,5,5,3,3,3,2,2,2,2};
        int[] matchsticks3 = {1,1,2,2,2};
        int[] matchsticks4 = {3,3,3,3,4};
        int[] matchsticks5 = {5,5,5,5,16,4,4,4,4,4,3,3,3,3,4};
        int[] matchsticks6 = {3,9,2,2,2,9,10,8,3,9,10,10,1,9,9};
        System.out.println(new MatchsticksToSquareBT().makesquare(matchsticks6));

    }

}
