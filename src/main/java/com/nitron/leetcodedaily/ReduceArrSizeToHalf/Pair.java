package com.nitron.leetcodedaily.ReduceArrSizeToHalf;

import lombok.AllArgsConstructor;
import lombok.Getter;


public class Pair {

    int key;
    int frequency;

    public Pair(int key, int frequency) {
        this.key = key;
        this.frequency = frequency;
    }

    public int getKey() {
        return key;
    }

    public int getFrequency() {
        return frequency;
    }
}
