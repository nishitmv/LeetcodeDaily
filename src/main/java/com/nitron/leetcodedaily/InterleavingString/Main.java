package com.nitron.leetcodedaily.InterleavingString;

public class Main {

    public static void main(String[] args) {

        String s1 = "aabd", s2 = "abdc", s3 = "aabdbadc";

        System.out.println(new InterleavingStringChecker().areInterleavingStrings(s1, s2, s3));


    }


}
