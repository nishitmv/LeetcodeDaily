package com.nitron.leetcodedaily.CandyByRatings;

import java.util.*;

public class CandyByRatings {
    public int calcNumOfCandies(int[] ratings) {

        int n = ratings.length;
        int[] resultLeft = new int[n];
        int[] resultRight= new int[n];
        Arrays.fill(resultLeft, 1);
        Arrays.fill(resultRight, 1);

        for (int i = 1; i < n; i++) {

            if (ratings[i]>ratings[i-1])
                resultLeft[i] = resultLeft[i-1]+1;
        }

        for (int i = n-2; i >=0; i--) {

            if (ratings[i]>ratings[i+1])
                resultRight[i] = resultRight[i+1]+1;
        }

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += Math.max(resultLeft[i],resultRight[i] );

        return sum;
    }
}
