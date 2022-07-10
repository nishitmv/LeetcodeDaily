package com.nitron.leetcodedaily.TwoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        new TwoSum().twoSum(nums, 9);

    }

    public int[] twoSum(int[] nums, int target) {


        if(nums.length==2)
            return new int[]{0,1};
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            // Do this to check if we want to consume/ override duplicates or not . If duplicate*2 = result, return those indices
            if(map.containsKey(nums[i]) && nums[i]*2==target)
            {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }
                map.put(nums[i], i);
        }

        map.forEach((val, idx)-> {
            int diff = target - val;
            if(map.containsKey(diff))
            {
                result[0] = idx;
                result[1] = map.get(diff);
            }
        });

        return result;


    }
}
