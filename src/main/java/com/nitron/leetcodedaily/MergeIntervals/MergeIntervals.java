package com.nitron.leetcodedaily.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
       List<int[]> tempresult = new ArrayList<>();
        int j=0;
        for(int i=0; i<intervals.length;)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];
            i++;
            while(i<intervals.length && intervals[i][0]<=end)
            {
                end = Math.max(intervals[i][1], end);
                i++;
            }
            tempresult.add(new int[]{start, end});
            j++;
        }
        return tempresult.toArray(new int[j][2]);
    }
}
