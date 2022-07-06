package com.nitron.leetcodedaily.LongestConsecutiveSequence;

public class LongestConsecutiveSequence {

    int[] heights;
    int[] root;
    public int calc(int[] arr) {

        heights = new int[10];
        root = new int[10];
        for( int i=0;i<10;i++)
        {
            heights[i] =1;
            root[i] = i;
        }

        for(int i =0;i<arr.length-1;i++)
        {
            union(arr[i], arr[i+1]);
        }

    return 0;

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
