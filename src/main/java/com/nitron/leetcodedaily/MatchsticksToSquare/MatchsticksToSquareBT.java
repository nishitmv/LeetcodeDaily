package com.nitron.leetcodedaily.MatchsticksToSquare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchsticksToSquareBT {


    public boolean makesquare(int[] matchsticks) {

        if (matchsticks.length < 4)
            return false;
List<Integer> list = new ArrayList<>();

        int sum = 0;
        for (int matchStick : matchsticks) {
            sum += matchStick;
            list.add(matchStick);
        }

        if (!(sum % 4 == 0))
            return false;

        Collections.sort(list);

        return makesquare(list, list.size(), sum / 4, 0, 0);

    }

    private boolean makesquare(List<Integer> matchsticks, int n, int sum, int sides, int tempSum ) {

        if(tempSum == sum)
        {
            sides++;
            tempSum=0;
        }
        if(tempSum>sum)
            return false;
        if(sides ==4)
            return true;

        for(int i=matchsticks.size()-1; i>=0;i--)
        {

            int val = matchsticks.get(i);
            tempSum+=val;
            matchsticks.remove(i);

            if(makesquare(matchsticks, n, sum,sides, tempSum))
                return true;

            matchsticks.add(i, val);
            tempSum-=val;

            if(matchsticks.size()==n)
                return false;

        }

        return false;

    }
}
