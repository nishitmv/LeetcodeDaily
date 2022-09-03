package com.nitron.leetcodedaily.PlatesBetweenCandles;

public class PlatesBetweenCandles {

    public static final String PIPE = "|";
    public static final char STAR = '*';

    public int[] platesBetweenCandles(String s, int[][] queries) {
   int[] result = new int[queries.length];
   int j=0;

        for (int[] query : queries) {
            String str1 = s.substring(query[0], query[1] + 1);
            int count = 0;
            int start = str1.indexOf(PIPE);
            int end = str1.lastIndexOf(PIPE);
            if (start>=0 && end>=0 && start != end) {
                char[] arr = str1.substring(start,end+1 ).toCharArray();
                for (char ch : arr) {
                    if (ch == STAR)
                        count++;
                }
                result[j] = count;
                j++;

            }
        }
        return result;
        }
    }

