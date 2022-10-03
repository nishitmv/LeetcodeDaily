package com.nitron.leetcodedaily.MinTimetoMakeRopeColorful;

import java.util.PriorityQueue;

public class MinTimeToMakeRopeColorful {

    public int minCost(String colors, int[] neededTime) {

        int n = colors.length();

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int sum =0;
       for(int i =1; i<n; i++)
       {
           while(i<n && colors.charAt(i) == colors.charAt(i-1))
           {
               heap.add(neededTime[i-1]);
               i++;
           }
           if( heap.size()>0) {
              i--;
               heap.add(neededTime[i]);
           }
               while(heap.size()>1)
           {
               sum+=heap.poll();
           }
           heap.poll();
       }
       return sum;
    }

}
