package com.nitron.leetcodedaily.StringReorganize;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class StringReorganizer {


    public static void main(String[] args) {
        System.out.println(new StringReorganizer().reorganizeString("aab"));
    }

    public String reorganizeString(String s) {

        if(s.length()==1)
            return s;

        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>(Comparator.comparingInt(Pair::getFreq).reversed());


        for(char ch: s.toCharArray())
        {
            map.computeIfPresent(ch, (k,v)-> v+1);
            map.putIfAbsent(ch,1);
        }

        map.forEach((ch,freq) -> heap.offer(new Pair(ch,freq)));

        StringBuilder result = new StringBuilder();
        while(!heap.isEmpty())
        {

            Pair pair = heap.poll();
            if(heap.size()==1 && (pair.getFreq()-heap.peek().getFreq())>1)
            {
                return "";
            }
            if(result.length()>0 && result.charAt(result.length()-1) == pair.val)
            {
                if(heap.isEmpty())
                    return "";
                Pair pair2 = heap.poll();

                result.append(pair2.getVal());
                if(pair2.getFreq()>1)
                {
                    heap.offer(new Pair(pair2.getVal(), pair2.getFreq()-1));
                }
            }
            result.append(pair.getVal());

            if(pair.getFreq()>1)
            {
                heap.offer(new Pair(pair.getVal(), pair.getFreq()-1));
            }
        }

        return result.toString();


    }

    public class Pair{

        char val;
        int freq;

        public Pair(char val, int freq)
        {
            this.val = val;
            this.freq = freq;

        }

        public char getVal()
        {
            return this.val;
        }


        public int getFreq()
        {
            return this.freq;
        }

    }
}
