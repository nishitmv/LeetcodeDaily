package com.nitron.leetcodedaily.MatchsticksToSquare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchsticksToSquare {


    public boolean makesquare(int[] matchsticks) {

        if (matchsticks.length < 4)
            return false;

        int sum = 0;
        for (int matchStick : matchsticks) {
            sum += matchStick;
        }

        if (!(sum % 4 == 0))
            return false;

        Arrays.sort(matchsticks);

        return makesquare(matchsticks, matchsticks.length - 1, sum / 4);

    }

    private boolean makesquare(int[] matchsticks, int n, int sum ) {

        List<Integer> visited = new ArrayList<>();

       for(int i=0;i<4;i++)
       {
           int sideSum =0;
           for(int j=n;j>=0;j--)
           {
               if(!visited.contains(j)&& sideSum+matchsticks[j]<sum) {
                   sideSum += matchsticks[j];
                   visited.add(j);
               }
               else if(!visited.contains(j)&& sideSum+matchsticks[j]==sum)
               {
                   visited.add(j);
                   break;
               }

           }
       }
        return visited.size() == n+1;

    }
}
