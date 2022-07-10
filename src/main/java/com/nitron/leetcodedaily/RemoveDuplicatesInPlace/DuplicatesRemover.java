package com.nitron.leetcodedaily.RemoveDuplicatesInPlace;

public class DuplicatesRemover {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n;i++)
        {
            int val = nums[i];
           i++;
            while(i<n && nums[i] == val)
            {
                nums[i] = 1000;
                i++;
            }
            i--;
        }

        int i=1, j=1;
        while(i<n && j<n) {
            if(nums[j] ==1000) {
                while (j < n && nums[j] == 1000  ) {
                    j++;
                }
                if(j<n) {
                    nums[i] = nums[j];
                    nums[j] = 1000;
                    i++;
                }
            }
            else {
                i++;
                j++;
            }
        }
        return i;
    }

}
