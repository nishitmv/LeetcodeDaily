package com.nitron.leetcodedaily.LongestIncrSubsequence;

import java.util.Arrays;

public class LongestIncrSubSequence {

    Integer[] memo;

    public int lengthOfLIS(int[] nums) {

        memo = new Integer[nums.length];
        Arrays.fill(memo, 1);

        int max = 0;

        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    memo[j] = Math.max(memo[i] + 1, memo[j]);

                }
            }

        for (Integer integer : memo) {
            max = Math.max(max, integer);
        }

        return max;
    }
}
