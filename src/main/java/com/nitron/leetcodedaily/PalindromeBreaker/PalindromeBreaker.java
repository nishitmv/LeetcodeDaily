package com.nitron.leetcodedaily.PalindromeBreaker;

public class PalindromeBreaker {

    public static void main(String[] args) {

        System.out.println(breakPalindrome("aba"));

    }

    public static String breakPalindrome(String palindrome) {

        if(palindrome.length()==1)
            return "";

        StringBuilder builder = new StringBuilder();
        boolean flag = false;
        for(int i=0; i<palindrome.length(); i++)
        {

            if(!flag && palindrome.charAt(i)!='a')
            {
                builder.append('a');
                flag = true;
            }
            else{
                builder.append(palindrome.charAt(i));
            }
        }

        if(isPalindrome(builder))
            flag = false;

        if(!flag)
        {
            builder = new StringBuilder(palindrome);
            builder.replace(palindrome.length()-1, palindrome.length(), "b");
        }

        return builder.toString();

    }


    private static boolean isPalindrome(StringBuilder builder){

        StringBuilder reverse = new StringBuilder(builder.toString());

        return builder.toString().equals(reverse.reverse().toString());

    }

}
