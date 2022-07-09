package com.nitron.leetcodedaily.painthouses3;

public class PaintHouses {
    Integer[][][] cache;

    public int calcMinCost(int[] houses, int[][] cost, int m, int n, int target) {

        cache = new Integer[m + 1][target+1][n + 1];


        if (m == 0 || n == 0)
            return 0;
        boolean areAllPainted = true;
        for (int house : houses) {
            if (house == 0) {
                areAllPainted = false;
                break;
            }
        }
        if (areAllPainted)
        {
            int neighbourhoods = 1;
            for (int i=1; i<m;i++) {
                if(houses[i]!= houses[i-1])
                    neighbourhoods++;
            }
            if(neighbourhoods == target)
                return 0;
            else return -1;

        }

        int res =  calcMinCost(houses, cost, m - 1, n, target, -1);

        return res==1000001 ? -1 : res;


    }

    int calcMinCost(int[] houses, int[][] costs, int house, int numColours, int neighborhood, int previousNHColor) {

        if(house == -1)
        {
            if( neighborhood ==0)
                return 0;
            else
                return 1000001;
        }
        if( neighborhood == -1 )
            return 1000001;

        if(previousNHColor!=-1 && cache[house][neighborhood][previousNHColor] !=null)
            return cache[house][neighborhood][previousNHColor];

        int minCost = 1000001;

            if(houses[house] == 0) {
                for (int color = 1; color <= numColours; color++) {
                    if (color == previousNHColor) {
                        minCost = Math.min(minCost, costs[house][color-1] + calcMinCost(houses, costs, house - 1, numColours, neighborhood, color));
                    } else {
                        minCost = Math.min(minCost, costs[house][color-1] + calcMinCost(houses, costs, house - 1,numColours, neighborhood - 1, color));
                    }
                }
            }
            else {
                if(houses[house] == previousNHColor)
                  minCost = Math.min(minCost, calcMinCost(houses, costs, house-1,numColours, neighborhood, houses[house]));
                else {
                    minCost = Math.min(minCost, calcMinCost(houses, costs, house-1,numColours, neighborhood-1, houses[house]));
                }
            }
            if(previousNHColor!=-1)
                return cache[house][neighborhood][previousNHColor] = minCost;
            else
                return minCost;
    }
}


