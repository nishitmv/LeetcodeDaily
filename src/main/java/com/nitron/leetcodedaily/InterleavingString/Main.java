package com.nitron.leetcodedaily.InterleavingString;

public class Main {

    public static void main(String[] args) {

        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";


        System.out.println(new InterleavingStringChecker().isInterleave(s1, s2, s3));


    }


}
