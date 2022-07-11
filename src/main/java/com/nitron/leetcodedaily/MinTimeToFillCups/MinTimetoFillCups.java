package com.nitron.leetcodedaily.MinTimeToFillCups;

import java.util.Arrays;

public class MinTimetoFillCups {

    public int fillCups(int[] amount) {

        Arrays.sort(amount);
        int count = 0;
       while(amount[2]!=0 &&amount[1]!=0)
       {
           amount[2]--;
           amount[1]--;
           count++;
       }
       if(amount[1]==0)
       {
           while(amount[2]!=0 &&amount[0]!=0)
           {
               amount[2]--;
               amount[0]--;
               count++;
           }
       }
       else
       {
           while(amount[1]!=0 &&amount[0]!=0)
           {
               amount[0]--;
               amount[1]--;
               count++;
           }
       }

       while (amount[0]>0)
       {
           amount[0]--;
           count++;
       }
        while (amount[1]>0)
        {
            amount[1]--;
            count++;
        }
        while (amount[2]>0)
        {
            amount[2]--;
            count++;
        }

        return count;
    }
}