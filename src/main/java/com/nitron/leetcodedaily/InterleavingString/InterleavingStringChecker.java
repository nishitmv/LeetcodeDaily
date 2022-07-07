package com.nitron.leetcodedaily.InterleavingString;

public class InterleavingStringChecker {

    Integer[][]  matrix;
    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s3.length();

        if( (s1.length() == 0 && s2.length() ==0)  && m!=0)
            return false;
        if(s1.length()>m || s2.length()>m)
            return false;
        if(s1.length()+ s2.length() >m)
            return false;
        matrix = new Integer[m+1][m+1];
        int s1Result =calcLongestCommonSubsequence(s3.toCharArray(), s1.toCharArray(), m, s1.length() );
        matrix = new Integer[m+1][m+1];
        int s2Result = calcLongestCommonSubsequence(s3.toCharArray(), s2.toCharArray(), m, s2.length());


        return (s1Result+s2Result == s3.length()) && s1Result==s1.length() && s2Result ==  s2.length();

    }
    private int calcLongestCommonSubsequence(char[] s1, char[] s2, int m, int n) {

        if(m==0 ||n==0)
            return 0;

        if(matrix[m][n]!= null)
            return matrix[m][n];

        if(s1[m-1] == s2[n-1])
        {
            return matrix[m][n] = 1+ calcLongestCommonSubsequence(s1, s2, m-1, n-1);
        }
        else {
            return matrix[m][n] =  Math.max(calcLongestCommonSubsequence(s1, s2, m, n-1), calcLongestCommonSubsequence(s1, s2, m-1, n));
        }

    }
}