package com.nitron.leetcodedaily.MaximumUnitsOnTruck;

import java.util.Arrays;
import java.util.Comparator;

public class MaxUnitsOnTruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, Comparator.comparingInt(box -> -box[1]));

        int units =0;

        for(int[] val : boxTypes)
        {

           if(val[0]<truckSize) {
               units+= val[0] * val[1];
                truckSize-=val[0];
           }
           else {
               units+= truckSize*val[1];
               return units;
           }

        }
        return units;

    }
}
