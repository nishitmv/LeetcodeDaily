package com.nitron.leetcodedaily.JumpGame6;

public class Main {

    public static void main(String[] args) {

        int[] nums = {1,-1,-2,4,-7,3};
        int k = 2;

        int[] nums2 = {10,-5,-2,4,0,3};

        int[] nums3 = {1,-5,-20,4,-1,3,-6,-3};

        System.out.println(new JumpGame6Optimized().calcMaxScore(nums2, 3));

    }

}
