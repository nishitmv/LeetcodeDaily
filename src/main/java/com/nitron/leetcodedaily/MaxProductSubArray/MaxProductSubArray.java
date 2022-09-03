package com.nitron.leetcodedaily.MaxProductSubArray;

public class MaxProductSubArray {

    public static void main(String[] args) {

        int[] nums = {2, -5, -2, -4, 3};

        System.out.println(new MaxProductSubArray().maxProduct(nums));

    }

    public int maxProduct(int[] nums) {


        int posProd = 0;
        int negProd = 0;
        int maxProd = Integer.MIN_VALUE;
        if (nums.length == 1) return nums[0];

        for (int num : nums) {
            if (num == 0) {
                posProd = 0;
                negProd = 0;
            } else if (num > 0) {

                posProd = posProd > 0 ? posProd * num : num;
                if (negProd != 0) negProd *= num;
            } else {

                int temp = posProd;
                if (negProd != 0) {
                    posProd = negProd * num;
                } else posProd = 0;


                negProd = temp > 0 ? temp * num : num;
            }

            maxProd = Math.max(maxProd, posProd);

        }

        return maxProd;
    }

}
