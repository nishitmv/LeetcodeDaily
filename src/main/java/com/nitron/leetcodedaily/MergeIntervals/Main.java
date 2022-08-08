package com.nitron.leetcodedaily.MergeIntervals;

public class Main {


    public static void main(String[] args) {

        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        for (int[] ints : new MergeIntervals().merge(intervals)) {

            for (int val : ints) {
                System.out.print(val+" ");
            }
            System.out.println();
        }

    }

}
