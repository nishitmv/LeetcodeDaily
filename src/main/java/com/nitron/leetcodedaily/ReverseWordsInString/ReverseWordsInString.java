package com.nitron.leetcodedaily.ReverseWordsInString;

public class ReverseWordsInString {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {
    int spaceCount =0;
    StringBuilder builder = new StringBuilder();
    s = s.trim();
        for( int i = s.length()-1; i>=0;i--)
        {
            if(s.charAt(i)==' ' )
            {
                if( spaceCount==0)
                {
                builder.append(s.charAt(i));
                    spaceCount++;
            }
            }
            else {
                builder.append(s.charAt(i));
                spaceCount=0;
            }
        }


        return builder.toString();
    }

}
