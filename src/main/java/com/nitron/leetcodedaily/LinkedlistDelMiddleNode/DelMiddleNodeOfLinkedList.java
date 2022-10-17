package com.nitron.leetcodedaily.LinkedlistDelMiddleNode;

import com.nitron.leetcodedaily.MergeKLists.ListNode;

public class DelMiddleNodeOfLinkedList {

    public static void main(String[] args) {



    }

    public ListNode deleteMiddle(ListNode head) {

        ListNode node = head;
        int len =0;
        while(node!=null)
        {
            node = node.next;
            len++;
        }

        if(len==1)
            return null;

        if(len ==2)
        {
            head.next = null;
            return head;
        }

        int mid = (int)Math.ceil((double)len/2);


        if(len%2==0)
            mid=mid+1;

        node = head;
        for(int i =1; i<mid ;i++)
        {
            node = node.next;
        }

        node.val = node.next.val;
        node.next = node.next.next;

        return head;

    }

}
