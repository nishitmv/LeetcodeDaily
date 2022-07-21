package com.nitron.leetcodedaily.SynchronizedSortedStrings;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedSortedIntegers {

    ReentrantLock lock = new ReentrantLock();
    AtomicInteger counter = new AtomicInteger();


    public static void main(String[] args) {

        new SynchronizedSortedIntegers().printIntegersSychronizedRoundRobin(5);

    }

    public void printIntegersSychronizedRoundRobin(int k) {

        CyclicBarrier barrier = new CyclicBarrier(k);

        for ( int i =0; i<k; i++) {
            int finalI = i;
         new Thread(() -> {
                System.out.println(finalI +"  "+Thread.currentThread().getName());
            }, "Thread "+i).start();
        }

    }

    class ThreadPrinter
    {

        public synchronized void printNum ( int i)
        {
            lock.lock();
            System.out.println(i +"  "+Thread.currentThread().getName());

            lock.unlock();
        }
    }
}
