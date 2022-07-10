package com.nitron.leetcodedaily.ThreeSum;

import java.util.*;

public class ThreeSumNCube {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> res = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 ) {
                int sum = -nums[i];
                for (int j = i + 1; j < n; j++) {
                    int sum2 = nums[j] - sum;
                    for (int k = j + 1; k < n; k++) {
                        if (nums[k] + sum2 == 0) {
                            List<Integer> tempres = new ArrayList<>();
                            tempres.add(nums[i]);
                            tempres.add(nums[j]);
                            tempres.add(nums[k]);
                            res.add(tempres);
                            break;
                        }
                    }
                }
            }
        }
        return new ArrayList<>(res);

    }
}

