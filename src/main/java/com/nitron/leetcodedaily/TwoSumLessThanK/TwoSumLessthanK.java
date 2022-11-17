package com.nitron.leetcodedaily.TwoSumLessThanK;

import java.util.*;

public class TwoSumLessthanK {

    public static void main(String[] args) {

        int[] nums = {34,23,1,24,75,33,54,8}; int k = 60;
        int[] nums1 = {254,914,110,900,147,441,209,122,571,942,136,350,160,127,178,839,201,386,462,45,735,467,153,415,875,282,204,534,639,994,284,320,865,468,1,838,275,370,295,574,309,268,415,385,786,62,359,78,854,944};
        int k1 = 200;
        int[] nums2 = {114,169,633,838,883,265,221,966,389,503,393,260,431,316,261,220,642,664,413,401,150,150,474,558,667,61,152,222,769,768,718,733,728,359,104,108,496,132,184,985,387,487,961,389,702,547,115,164,388,318};
        int k2 = 100;
        int[] nums3 = {803,468,292,154,924,424,197,277,753,86,984,144,105,450,287,265,655,404,407,794,513,976,241,272,84,503,65,654,805,413,362,907,297,473,113,567,646,607,806,674,424,753,870,574,765,170,603,696,513,58};
        int k3 = 300;
        System.out.println(new TwoSumLessthanK().twoSumLessThanK(nums, k));

    }

    public int twoSumLessThanK(int[] nums, int k) {

        int i =0;
        int j=1;
        int ans =-1;


    while(i<nums.length-1 ) {

            if (j == nums.length) {
                i++;
                j = i + 1;
            }
            if (i < nums.length - 1 && j < nums.length) {

                int sum = nums[i] + nums[j];
                if (sum < k) {
                    ans = Math.max(ans, sum);
                    j++;
                } else if (nums[i] >= k) {
                    i++;
                    j = i + 1;
                } else if (nums[j] >= k) {
                    j++;

                } else j++;
            }
        }

        return ans;

    }
}
