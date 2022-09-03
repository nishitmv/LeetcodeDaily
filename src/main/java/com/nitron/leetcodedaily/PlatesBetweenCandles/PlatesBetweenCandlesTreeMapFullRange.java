package com.nitron.leetcodedaily.PlatesBetweenCandles;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class PlatesBetweenCandlesTreeMapFullRange {


    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] result = new int[queries.length];

        var arr = s.toCharArray();
        int start = s.indexOf("|");
        int end = s.lastIndexOf("|");
        int i=start-1;
        int j = 0;
        TreeMap<Integer, Integer> ranges = new TreeMap<>();
        int count =0;
        while(i<=end )
        {
            if(s.charAt(i)=='|')
                ranges.put(i, count++);
            i++;
        }

        for(int[] query : queries)
        {
            int x = query[0];
            int  y = query[1];

        }

        return result;
    }
}

