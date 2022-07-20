package com.nitron.leetcodedaily.RearrangeString;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class StringRearranger {

    public String rearrangeString(String input) {

        if (input.length() == 0)
            return "";

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.comparingInt(Pair::getFrequency).reversed());

        Map<Character, Integer> map = new HashMap<>();

        for (char key : input.toCharArray()) {
            map.computeIfPresent(key, (k, freq) -> freq = freq + 1);
            map.putIfAbsent(key, 1);
        }
        if (map.size() == 1)
            return "";

        map.forEach((key, freq) -> maxHeap.add(new Pair(key, freq)));

        StringBuilder builder = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Pair pair = maxHeap.poll();

            builder.append(pair.getKey());

            if (pair.getFrequency() > 1) {
                Pair newPair = new Pair(pair.getKey(), pair.getFrequency() - 1);
                maxHeap.add(newPair);
            }
        }

        return builder.toString();

    }


}
