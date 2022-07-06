package com.nitron.leetcodedaily.LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequenceWithNegatives {
    int[] heights;
    int[] root;
    public int calc(int[] arr) {
        int n = arr.length;

        if(n == 0 || n == 1)
            return n;

        heights = new int[n+1];
        root = new int[n+1];

        for( int i=0;i<n+1;i++)
        {
            heights[i] =1;
            root[i] = i;
        }

        Set<Integer> set = new HashSet<>();

        for(int val : arr)
            set.add(val);

        Map<Integer, Integer> map = new HashMap<>();
        int i =0;
        for(int val : set)
        {
            if(!map.containsKey(val))
                map.put( val, i);

            if(map.containsKey(val-1)) {
                union(i, map.get(val-1));

            }
            if(map.containsKey(val+1)) {
                union(i, map.get(val+1));

            }
            i++;
        }

        Map<Integer, Integer> rootmap = new HashMap<>();


        for (int j =0; j<n ; j++) {
            int rootOfVal = find(j);
            rootmap.computeIfPresent(rootOfVal, (k, v) -> v + 1);
            rootmap.putIfAbsent(rootOfVal, 1);

        }

        int result =0;

        for(Map.Entry<Integer, Integer> entry : rootmap.entrySet())
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

