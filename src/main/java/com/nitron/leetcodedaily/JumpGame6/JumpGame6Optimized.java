package com.nitron.leetcodedaily.JumpGame6;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class JumpGame6Optimized {
// Wrong anwer for some test cases.
    public int calcMaxScore(int[] nums, int k) {

        return calcMaxScore(nums, nums.length , k);

    }

    private int calcMaxScore(int[] nums, int n,  int k) {

        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> -pair.getValue()));

        maxHeap.offer(new Pair<>(0, nums[0]));
        int max = nums[0];
        for(int i=1;i<n;i++)
        {
            if(maxHeap.peek().getKey()<i-k)
                maxHeap.poll();

            max = nums[i] + Math.max(max, maxHeap.peek().getValue());
            maxHeap.offer(new Pair<>(i, max));
        }

        return max;

    }
}
