package com.nitron.leetcodedaily.MinCostClimbingStairs;

public class MinCostClimbingStairs {
    Integer[] cache ;
    public int calcMinCost(int[] cost) {
        cache = new Integer[cost.length+1];
        if(cost.length ==0)
            return 0;
        if(cost.length==1)
            return cost[0];
        if(cost.length==2)
            return Math.min(cost[0], cost[1]);


        return Math.min(calcMinCost(cost, cost.length-1), calcMinCost(cost, cost.length-2));
    }

    private int calcMinCost(int[] cost,  int n) {

        if(n<0)
            return 0;
        if(n==0 || n==1)
            return cost[n];

        if(cache[n]!=null)
            return cache[n];

        return cache[n] = cost[n]+ Math.min(calcMinCost(cost,n-1),calcMinCost(cost,n-2));

    }
}
