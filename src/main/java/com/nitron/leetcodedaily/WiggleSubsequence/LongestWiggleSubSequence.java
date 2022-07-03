package com.nitron.leetcodedaily.WiggleSubsequence;

public class LongestWiggleSubSequence {

    public int find(int[] arr) {

        int n = arr.length;

        if (n == 0 || n == 1)
            return n;
        if (n == 2)
            if (arr[0] != arr[1])
                return n;
            else return 0;

        // initialize both inc and dec to 1 and start from second element .
        int inc = 1;
        int dec = 1;

        for (int i = 1; i < n; ) {

            if(arr[i]==arr[i-1])
            {
                i++;
                continue;
            }

            while (i < n && arr[i] > arr[i - 1]) {
                // White it continues to increase inc will remain dec+1;
                inc = dec + 1;
                i++;
            }

            while (i < n && arr[i] < arr[i - 1]) {
                //while it continues to decrease dec will remain inc+1;
                dec = inc + 1;
                i++;
            }
        }

        return Math.max(inc, dec);

    }
}
