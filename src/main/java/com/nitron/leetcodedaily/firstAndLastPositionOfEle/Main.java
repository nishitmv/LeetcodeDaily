package com.nitron.leetcodedaily.firstAndLastPositionOfEle;

public class Main {

    public static void main(String[] args) {

        int[] nums = {5,7,7,8,8,10};
        int target  = 6;

        for (int i : new FirstAndLastPosFinder().searchRange(nums, target)) {
            System.out.print(i +" ");

        }

    }

}
