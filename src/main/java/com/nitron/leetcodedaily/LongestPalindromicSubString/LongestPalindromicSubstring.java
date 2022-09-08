package com.nitron.leetcodedaily.LongestPalindromicSubString;

public class LongestPalindromicSubstring {

    String calcLongestPalindromicSubstring(String str1) {

        String str2 = new StringBuilder(str1).reverse().toString();

        if (str1.equals(str2))
            return str1;

        int m = str1.length();

        Integer[][] matrix = new Integer[m + 1][m + 1];

        for (int i = 0; i < m + 1; i++)
            matrix[i][0] = 0;

        for (int j = 0; j < m + 1; j++)
            matrix[0][j] = 0;
        int start = 0;
        int length = 0;

        for (int i = 1; i < m + 1; i++)
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = 0;
                }
                if (matrix[i][j] > length) {

                    length = matrix[i][j];
                    start = i-length;
                }
            }
        return str1.substring(start, start+length);
    }

}
