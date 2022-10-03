package com.nitron.leetcodedaily.MinTimetoMakeRopeColorful;

public class MinTimeMakeRopeColorful {

    public int minCost(String colors, int[] neededTime) {

        int n = colors.length();

        int sum = 0;
        for (int i = 1; i < n; i++) {
            int maxCost = 0;
            int sumCost = 0;
            while (i < n && colors.charAt(i) == colors.charAt(i - 1)) {
                maxCost = Math.max(neededTime[i - 1], maxCost);
                sumCost += neededTime[i - 1];
                i++;
            }
            if (sumCost > 0) {
                i--;
                maxCost = Math.max(neededTime[i], maxCost);
                sumCost += neededTime[i];
            }
            sum += sumCost - maxCost;

        }
        return sum;

    }
}
