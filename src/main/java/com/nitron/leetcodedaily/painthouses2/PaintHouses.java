package com.nitron.leetcodedaily.painthouses2;

public class PaintHouses {

    Integer[][] cache;

    public int calcMinCost(int[][] costs) {
        if (costs.length == 0)
            return 0;
        int numColors = costs[0].length;

            cache = new Integer[costs.length + 1][numColors + 1];

        return calcMinCost(costs, costs.length - 1, -1, numColors);

    }

    private int calcMinCost(int[][] costs, int n, int colorChoice, int numColors) {

        if (n < 0)
            return 0;

        if (colorChoice >= 0 && cache[n][colorChoice] != null)
            return cache[n][colorChoice];

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < numColors; i++) {

            if (i != colorChoice) {
                minCost = Math.min(minCost, costs[n][i] + calcMinCost(costs, n - 1, i, numColors));
            }
        }
        return cache[n][colorChoice] = minCost;

    }
}
