package com.nitron.leetcodedaily.MeetingRooms2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a-> a[0]));

        int numRooms = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int[] interval : intervals)
        {

            if(heap.isEmpty())
            {
                numRooms++;
                heap.offer(interval[1]);
            }
            else if(heap.peek()<=interval[0])
            {
                heap.poll();
                heap.offer(interval[1]);
            }
            else if(heap.peek()>interval[0])
            {
                numRooms++;
                heap.offer(interval[1]);
            }

        }
        return numRooms;
    }
}
