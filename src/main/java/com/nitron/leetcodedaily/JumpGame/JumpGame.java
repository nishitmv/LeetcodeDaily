package com.nitron.leetcodedaily.JumpGame;

public class JumpGame {

    Boolean[] cache ;
    public boolean jumpPossible(int[] nums) {
        cache = new Boolean[10000];
        if(nums[0] >= nums.length-1)
            return true;
        return calcJumpPossible(nums, 0, nums.length-1);

    }

    private boolean calcJumpPossible(int[] nums,int i, int n) {

        if(i>=n)
            return true;
        if(cache[i]!=null)
            return cache[i];
        boolean result = false;
        for(int k =i; k<=n && k<i+nums[i] ;)
        {
            boolean tempRes =  calcJumpPossible(nums, ++k, n);
            result = result || tempRes;
        }

        return cache[i] = result;
    }
}
