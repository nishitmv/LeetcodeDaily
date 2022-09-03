package com.nitron.leetcodedaily.PlatesBetweenCandles;


import java.util.ArrayList;
import java.util.List;

public class PlatesBetweenCandlesPreCalcRanges {


    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] result = new int[queries.length];

        var arr = s.toCharArray();
        int start = s.indexOf("|");
        int end = s.lastIndexOf("|");
        int i=start;
        int j = 0;
        List<Range> rangeList = new ArrayList<>();
        while(i<end )
        {
            int pipestart =i;
            int count =0;
            while(s.charAt(++i)=='*')
            {
               count++;
            }
            rangeList.add(new Range(pipestart, i, count));
        }

        for(int[] query : queries)
        {
            int x = query[0];
            int  y = query[1];
           var data =  rangeList.stream().filter(range-> range.start>=x ).filter(range -> range.end<=y).reduce((range1, range2)-> new Range(x, y, range1.count+range2.count));
           if(data.isPresent())
            result[j] = data.get().count;
           else result[j] =0;
           j++;
        }

        return result;
    }
}

