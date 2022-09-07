package com.nitron.leetcodedaily.BoatsToSavePeople;

import java.util.Arrays;

public class BoatsToSavePeople {

    public static void main(String[] args) {

        int[] people = {3,2,3,2,2};
        int limit =6 ;

        System.out.println(new BoatsToSavePeople().numRescueBoats(people, limit));
    }

    private int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int count=0;
        int j=0;
        int i= people.length-1;
        while ( i>=j )
        {
            int numPeeps =0;
            int temp = limit;
            while( i>=j && temp>=people[i] && numPeeps<2 ) {
                temp -= people[i];
                i--;
                numPeeps++;
            }
            while(temp>=people[j] && numPeeps<2)
            {
                temp-=people[j];
                j++;
                numPeeps++;
            }
            count++;
        }
        return count;
    }

}
