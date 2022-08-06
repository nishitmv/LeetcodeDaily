package com.nitron.leetcodedaily.LongestSubstrWithAtmost2DistChars;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringCalc {

    public int lengthOfLongestSubstringTwoDistinct(String s) {

         Map<Character, Integer> map = new HashMap<>();

       int i=0; int j=0;
       int result=0;
       int tempRes = 0;
       while(i<s.length() && j<s.length())
       {
           while(j<s.length() && map.size()<=2) {
               map.computeIfPresent(s.charAt(j), (k, v) -> v + 1);
               map.putIfAbsent(s.charAt(j), 1);
               result = Math.max(result, tempRes);
               tempRes++;
               j++;
           }
           while(map.size()>2)
           {
               char key = s.charAt(i);
               if(map.get(key)>1)
                map.computeIfPresent(key, (k, v) -> v - 1);
               else map.remove(key);
               i++;
               tempRes--;
           }

       }
        result = Math.max(result, tempRes);
       return result;
    }

}
