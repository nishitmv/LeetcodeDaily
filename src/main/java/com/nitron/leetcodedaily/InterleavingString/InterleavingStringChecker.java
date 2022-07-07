package com.nitron.leetcodedaily.InterleavingString;

public class InterleavingStringChecker {

    Boolean[][]  matrix;
    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s3.length();

        if( (s1.length() == 0 && s2.length() ==0)  && m!=0)
            return false;
        if(s1.length()>m || s2.length()>m)
            return false;
        if(s1.length()+ s2.length() >m)
            return false;
        matrix = new Boolean[s1.length()+1][s2.length()+1];

        return isInterleave(s1, 0, s2, 0, s3);

    }

    private boolean isInterleave(String s1, int i, String s2, int j, String s3) {

        if(i+j == s3.length())
            return true;

        if(matrix[i][j] != null)
            return matrix[i][j];

        if(i<s1.length() && s3.charAt(i+j) == s1.charAt(i))
        {
             matrix[i][j] = isInterleave(s1, i+1, s2, j, s3);
             if(matrix[i][j])
                 return true;
        }
        if(j<s2.length() && s3.charAt(i+j) == s2.charAt(j))
        {
             matrix[i][j] = isInterleave(s1, i, s2, j+1, s3);
            if(matrix[i][j])
                return true;
        }
        return matrix[i][j] = false;

    }
}