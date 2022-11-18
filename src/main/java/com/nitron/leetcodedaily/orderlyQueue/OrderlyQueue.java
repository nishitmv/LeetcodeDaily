package com.nitron.leetcodedaily.orderlyQueue;

import java.util.Arrays;

public class OrderlyQueue {

    public static void main(String[] args) {

        String s = "baaca";
        int k = 1;

        System.out.println(new OrderlyQueue().orderlyQueue(s, k));

    }

    public String orderlyQueue(String str, int k) {

        if (k > 1) {
            char[] carr = str.toCharArray();
            Arrays.sort(carr);
            return new String(carr);
        } else {
            String temp = str;
            for (int i = 0; i < str.length(); i++) {
                String str1 = str.substring(i)+str.substring(0,i);
                if(temp.compareTo(str1)>0)
                    temp = str1;
            }
            return temp;
        }

    }
}
