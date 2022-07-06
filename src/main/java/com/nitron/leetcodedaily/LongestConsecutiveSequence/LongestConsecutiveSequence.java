package com.nitron.leetcodedaily.LongestConsecutiveSequence;

import java.util.*;

public class LongestConsecutiveSequence {

    int[] heights;
    int[] root;
    public int calc(int[] arr) {
        int n = arr.length;

        if(n == 0 || n == 1)
            return n;

        int maxEle =0;
        for (int j : arr) {
            maxEle = Math.max(maxEle, j);
        }

        heights = new int[maxEle+1];
        root = new int[maxEle+1];

        for( int i=0;i<maxEle+1;i++)
        {
            heights[i] =1;
            root[i] = i;
        }

        List<Integer> list = new ArrayList<>();
        for( int val : arr)
        {
            if(!list.contains(val))
                list.add(val);

           if(list.contains(val-1)) {
               union(val, val - 1);

           }
               if(list.contains(val+1)) {
                   union(val, val + 1);

               }
        }

        Map<Integer, Integer> map = new HashMap<>();

        Set<Integer> set = new HashSet<>();

        for (int val: arr)
            set.add(val);

        for (int val : set) {
            int rootOfVal = find(val);
            map.computeIfPresent(rootOfVal, (k, v) -> v + 1);
            map.putIfAbsent(rootOfVal, 1);

        }

        int result =0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            result = Math.max(result, entry.getValue());
        }


        return result;

    }

    private int find(int val)
    {
        if(val == root[val])
            return val;
        else {
            root[val] = find(root[val]);
            return root[val];
        }
    }

    private void union(int x, int y)
    {
        int rootX = find(x);
        int rootY = find(y);

        if(heights[rootX]> heights[rootY])
        {
            root[rootY] = rootX;
        }
        else if(heights[rootY]>heights[rootX])
        {
            root[rootX] = rootY;
        }
        else {
            root[rootY] = rootX;
            heights[rootX]++;
        }
    }

}
