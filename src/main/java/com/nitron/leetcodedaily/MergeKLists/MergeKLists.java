package com.nitron.leetcodedaily.MergeKLists;

import java.util.PriorityQueue;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {


        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (ListNode node : lists) {
            while(node!=null) {
                heap.offer(node.val);
                node = node.next;
            }
            }
        ListNode root = new ListNode();
        if(!heap.isEmpty())
            root = new ListNode(heap.poll());
        ListNode node = root;
        while(heap.size()>0)
        {
            node.next = new ListNode(heap.poll());
            node = node.next;
        }

        return root;
    }
}
