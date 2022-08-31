package com.nitron.leetcodedaily.KPairsWithSmallestSum;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestSum {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<List<Integer>> maxheap = new PriorityQueue<>((l1, l2 )-> Integer.compare(l2.get(0) + l2.get(1), l1.get(0) + l1.get(1)));


        for (int val1: nums1)
            for (int val2 : nums2) {
                List<Integer> lst = new ArrayList<>(2);
                lst.add(val1);
                lst.add(val2);
                maxheap.offer(lst);
                if (maxheap.size() > k)
                    maxheap.poll();
            }

        return new ArrayList<>(maxheap);
    }

}
