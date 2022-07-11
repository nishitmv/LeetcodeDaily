package com.nitron.leetcodedaily.MinTimeToFillCups;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinTimeToFillCupsHeap {

    public int fillCups(int[] amount) {
        int count = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        if(amount[0] ==0 && amount[1] ==0 && amount[2]==0)
            return 0;

        for(int num: amount)
        {
            if(num>0)
                heap.offer(num);
        }

        while(!heap.isEmpty()) {
            int a = heap.poll()-1;
            int b=0;
            if(!heap.isEmpty()) {
                b = heap.poll()-1;
            }

            count++;

            if(a>0)
                heap.offer(a);
            if(b>0)
                heap.offer(b);

        }
        return count;
    }

}
