package com.nitron.leetcodedaily.MinMovesToEqualArrElements;

import java.util.PriorityQueue;

public class MinMovesCalc {


    public int minMoves2(int[] nums) {

        int n = nums.length ;

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int mid = 0;
        if(n%2==0)
            mid = n/2;
        else
            mid = (n/2)+1;
        for(int num: nums)

        {
            heap.add(num);


            if(heap.size()>mid)
                heap.remove();
        }

        int median = heap.remove();

        int res = 0;
        for(int num: nums)
        {
            if(num<median)
                res+=median-num;
            if(num>median)
                res+= num-median;
        }

        return res;
    }
}
