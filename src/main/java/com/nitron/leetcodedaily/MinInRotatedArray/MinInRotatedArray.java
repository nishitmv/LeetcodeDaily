package com.nitron.leetcodedaily.MinInRotatedArray;

public class MinInRotatedArray {


    public static void main(String[] args) {
        // you can write to stdout for debugging purposes, e.g.
        int[] arr = {23, 54, 87, 94, 1, 7, 9, 21};
        new MinInRotatedArray().search(arr);

    }

    public int search(int[] arr) {

        int n = arr.length;

        if (arr[0] < arr[n - 1]) {
            return arr[0];
        } else {
            return binSearchOnRotatedArray(arr, n);
        }

    }


    public int binSearchOnRotatedArray(int[] arr, int n) {

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1])
                return mid;

            else if (arr[mid] > arr[end] && arr[mid] > arr[start]) {
                start = mid + 1;
            } else if (arr[mid] < arr[start]) {
                end = mid - 1;
            }
            else if(arr[mid]<arr[end])
            {
                end = end-1;
            }
        }
        return -1;

    }
}
