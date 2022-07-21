package com.nitron.leetcodedaily.SynchronizedSortedStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PrintInorder {

    public static void main(String[] args) throws InterruptedException {

        int k = 5;

        for (int j = 0; j < 10; j++) {
            List<Callable<String>> list = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                list.add(new PrintNumsThread(i));
            }
            ExecutorService exec = Executors.newFixedThreadPool(k);
            List<Future<String>> futures = exec.invokeAll(list);

            futures.forEach(stringFuture -> {
                try {
                    System.out.println(stringFuture.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
