package com.nitron.leetcodedaily.SynchronizedSortedStrings;

import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;

@AllArgsConstructor
public class PrintNumsThread implements Callable<String> {

private int num;


    @Override
    public String call() {
        Thread.currentThread().setName("Thread "+num);
        return num+" Thread "+num;
    }


}
