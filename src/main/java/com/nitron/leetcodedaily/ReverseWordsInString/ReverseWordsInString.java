package com.nitron.leetcodedaily.ReverseWordsInString;

public class ReverseWordsInString {

    public static void main(String[] args) {
        System.out.println(reverseWords("the  sky  is blue"));
    }

    public static String reverseWords(String s) {

    StringBuilder builder = new StringBuilder();
    s = s.trim();
        int i = s.length()-1;
        while( i>=0)
        {
            int j=i+1;
           while(i>=0 && s.charAt(i)!=' ')
           {
               i--;
           }
            builder.append(s, i+1, j).append(" ");
            while(i>=0 && s.charAt(i)==' ')
            {
                i--;
            }
        }
        return builder.toString().trim();
    }

}
