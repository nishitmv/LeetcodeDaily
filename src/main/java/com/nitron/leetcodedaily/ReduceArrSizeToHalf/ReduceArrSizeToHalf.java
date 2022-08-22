package com.nitron.leetcodedaily.ReduceArrSizeToHalf;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArrSizeToHalf {


    public int minSetSize(int[] arr) {
        PriorityQueue<Pair> heap = new PriorityQueue<>(Comparator.comparingInt(Pair::getFrequency).reversed());
        int length = arr.length/2;
        Map<Integer, Integer> map = new HashMap<>();

        for(int val: arr)
        {
            map.computeIfPresent(val, (k,v)-> v+1);
            map.putIfAbsent(val, 1);
        }

        map.forEach((k,v)-> heap.offer(new Pair(k,v)));

        int halfSize = 0;
        int result =0;
        while(halfSize<length) {
            halfSize+=heap.poll().getFrequency();
            result++;
        }
        return result;

    }
}
