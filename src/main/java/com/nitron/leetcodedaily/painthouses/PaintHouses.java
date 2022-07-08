package com.nitron.leetcodedaily.painthouses;

public class PaintHouses {

    Integer[][] cache ;
    public int calcMinCost(int[][] costs) {
            if( costs.length ==0)
                return 0;
            if( costs.length ==1)
                return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);

        cache = new Integer[costs.length+1][3];

            return calcMinCost(costs, costs.length-1, -1);

    }

    private int calcMinCost(int[][] costs, int n, int colorChoice) {

        if (n < 0)
           return 0;

        if(colorChoice>=0 && cache[n][colorChoice] != null)
            return cache[n][colorChoice];

        int red = Integer.MAX_VALUE;
        int green =Integer.MAX_VALUE;
        int blue =Integer.MAX_VALUE;

        if (colorChoice ==-1) {
            red = costs[n][0]+ calcMinCost(costs, n - 1, 0);
            blue= costs[n][1]+ calcMinCost(costs, n - 1, 1);
            green= costs[n][2]+ calcMinCost(costs, n - 1, 2);
            return  Math.min(Math.min(red, green), blue);
        }
        if (colorChoice == 0) {
             blue= costs[n][1]+ calcMinCost(costs, n - 1, 1);
            green= costs[n][2]+ calcMinCost(costs, n - 1, 2);
            return cache[n][0] = Math.min(green , blue);
        }
        if (colorChoice == 1) {
             red= costs[n][0]+ calcMinCost(costs, n - 1, 0);
             green= costs[n][2]+ calcMinCost(costs, n - 1, 2);
            return cache[n][1] = Math.min(green , red);
         }
        if (colorChoice == 2) {
            red= costs[n][0]+ calcMinCost(costs, n - 1, 0);
            blue= costs[n][1]+ calcMinCost(costs, n - 1, 1);
            return cache[n][2] = Math.min(blue , red);
        }

        return 0;
    }
}
