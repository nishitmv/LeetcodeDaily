package com.nitron.leetcodedaily.GroupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strs =  {"eat","tea","tan","ate","nat","bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));

    }


    public List<List<String>> groupAnagrams(String[] strs) {

        Map<Map<Character, Integer>, List<String>> map= new HashMap<>();

        for (String str : strs) {

            Map<Character, Integer> charmap = new HashMap<>();
            for (char c : str.toCharArray()) {
                charmap.computeIfPresent(c, (k,v)-> v+1);
                charmap.putIfAbsent(c,1);
            }

            map.computeIfPresent(charmap, (k, v) -> {
                v.add(str);
                return v;
            });
            map.computeIfAbsent(charmap, (k)-> {
                List<String> lst= new ArrayList<>();
                lst.add(str);
                return lst;
            });

        }

        List<List<String>> result = new ArrayList<>(map.size());
        map.forEach((k,v)-> result.add(v));
        return result;
    }
}
