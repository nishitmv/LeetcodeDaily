package com.nitron.leetcodedaily.ContinuousSubArrSum;

public class ContSubArrSum {
    public boolean checkSubarraySum(int[] nums, int k) {

        if(nums.length<2)
            return false;
        if(nums.length==2)
            return (nums[0]+nums[1])%k ==0;

        int i =0;
        int j=0;

        int n = nums.length;
        int tempSum = 0;
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
            while(j<n) {
                tempSum += nums[j];
                if(j>0)
                    arr[j]= arr[j-1]+nums[j];
                j++;
                if ((j - i) >= 2 && tempSum % k == 0)
                    return true;

            }

          for(i=0; i<n;i++)
          {
              for(j=i+2;j<n;j++)
              {
                  if( (arr[j]-arr[i])%k==0)
                      return true;
              }
          }

        return false;
    }
}
