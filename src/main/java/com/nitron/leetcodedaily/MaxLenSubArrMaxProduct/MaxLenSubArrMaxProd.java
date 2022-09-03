package com.nitron.leetcodedaily.MaxLenSubArrMaxProduct;

import java.util.*;

public class MaxLenSubArrMaxProd {

    public static void main(String[] args) {
        int[] arr = {-16, 0, -5, 2, 2, -13, 11, 8};
        int[] arr2 = {-1,-2,-3,0,1};

        System.out.println(new MaxLenSubArrMaxProd().getMaxLen(arr));
    }

    public int getMaxLen(int[] nums) {
      int posSubArrLen =0;
      int negSubArrLen=0;
      int max =0;

      for(int i =0; i<nums.length;i++)
      {
          if(nums[i]==0)
          {
              posSubArrLen=0;
              negSubArrLen=0;
          }
          else if(nums[i]>0)
          {
              // If POsitive increment pos subarray length also increment neg subarray length if its already greater than 0.
              posSubArrLen++;
              if(negSubArrLen>0)
                  negSubArrLen++;
          }
          else {
              // If negative number Swap postive and neg sub array lengths if value is negative.
              int temp = posSubArrLen;
              if(negSubArrLen>0)
                  posSubArrLen= negSubArrLen+1;
              else posSubArrLen=0;
              negSubArrLen = temp+1;
          }
          max = Math.max(max, posSubArrLen);
      }

        return max;
    }
}
