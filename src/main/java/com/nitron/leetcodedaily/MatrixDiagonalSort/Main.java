package com.nitron.leetcodedaily.MatrixDiagonalSort;

public class Main {

    public static void main(String[] args) {

        int[][] matrix = {{3,3,1,1},
                          {2,2,1,2},
                          {1,1,1,2}};

        int[][] matrix2 = {{11,25,66,1,69,7},
                           {23,55,17,45,15,52},
                           {75,31,36,44,58,8},
                           {22,27,33,25,68,4},
                           {84,28,14,11,5,50}};

        for (int[] arr : new MatrixDiagonalSorter().diagonalSort(matrix2)) {

            for (int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();

        }

    }
}
