package com.nitron.leetcodedaily.SynchronizedSortedStrings;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedSortedIntegers {

    ReentrantLock lock = new ReentrantLock();
    AtomicInteger counter = new AtomicInteger();

    public void printIntegersSychronizedRoundRobin(int k) {

        ExecutorService pool = Executors.newFixedThreadPool(k);


        for ( int i =0; i<k; i++)
            pool.submit( () -> {
                lock.lock();
                int val = counter.incrementAndGet() ;
               new ThreadPrinter().printNum(val);
                if(val == k)
                    counter = new AtomicInteger();
                lock.unlock();
            });
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
