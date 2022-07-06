package com.nitron.leetcodedaily.LongestConsecutiveSequence;

import java.util.*;

public class LongestConsSequence {

    public int calc(int[] arr)
    {

        Set<Integer> set = new TreeSet<>();

        for(int val: arr)
        {
            set.add(val);
        }

        List<Integer> list = new ArrayList<>(set);

        int tempMax=1;
        int max=0;
        for(int i =1; i<list.size() ; i++) {

            if(list.get(i)== list.get(i-1)+1)
                tempMax++;
            else {
                max = Math.max(max, tempMax);
                tempMax =1;
            }
        }
        max = Math.max(tempMax, max);

        return max;
    }

}
