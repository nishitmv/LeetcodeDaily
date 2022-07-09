package com.nitron.leetcodedaily.JumpGame6;

public class JumpGame6 {

    Integer[] cache ;
    public int calcMaxScore(int[] nums, int k) {
        cache = new Integer[nums.length+1];
        return calcMaxScore(nums, nums.length , 0, k);

    }

    private int calcMaxScore(int[] nums, int n, int i, int k) {

        if(i==n-1)
            return nums[n-1];

        if(cache[i]!=null) {
            return cache[i];
        }
        int max = Integer.MIN_VALUE;

        for (int j = i+1; j <= i + k && j<n; j++) {
            max = Math.max(max, (nums[i] + calcMaxScore(nums, n, j, k)));
        }
        cache[i] = max;
        return max;
    }
}
