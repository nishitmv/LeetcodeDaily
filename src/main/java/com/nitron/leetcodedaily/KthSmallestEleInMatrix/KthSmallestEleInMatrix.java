package com.nitron.leetcodedaily.KthSmallestEleInMatrix;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestEleInMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i =0; i<matrix.length; i++)
            for(int j = 0; j<matrix.length;j++)
            {

                maxHeap.add(matrix[i][j]);

                if(maxHeap.size()>k)
                    maxHeap.poll();

            }
return maxHeap.poll();

    }

}
