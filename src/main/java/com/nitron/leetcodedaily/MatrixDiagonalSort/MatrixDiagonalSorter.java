package com.nitron.leetcodedaily.MatrixDiagonalSort;

import java.util.*;

public class MatrixDiagonalSorter {

    public int[][] diagonalSort(int[][] matrix) {

        int[][] sortedMatrix = new int[matrix.length][matrix[0].length];

        int m = matrix.length;
        int n = matrix[0].length;

        int i = m-1;

        Map<Integer, List<Integer>> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        while(i>0)
        {
            int j =0;
            int k =i;
            List<Integer> list = new ArrayList<>();
            while(j<n && k<m)
            {
               list.add(matrix[k][j]);
               k++;
               j++;
            }
            Collections.sort(list);

            map1.put(i, list);
            i--;
        }

        while(i<n)
        {
            int k=0;
            int j =i;
            List<Integer> list = new ArrayList<>();
            while(j<n && k<m)
            {
                list.add(matrix[k][j]);
                k++;
                j++;
            }
            Collections.sort(list);

            map2.put(i, list);
            i++;
        }
        i = m-1;
        while(i>0) {
            int j = 0;
            int k = i;

            for (int val : map1.get(i)) {
                sortedMatrix[k][j] = val;
                k++;
                j++;
            }
            i--;
        }
        while(i<n) {
            int k = 0;
            int j = i;
            for (int val : map2.get(i)) {
                sortedMatrix[k][j] = val;
                k++;
                j++;
            }
            i++;
        }
        return sortedMatrix;
    }

}
