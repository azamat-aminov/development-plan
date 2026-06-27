package com.dev.development.plan.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

//  private final AtomicInteger atomicInteger = new AtomicInteger();
//
//  public void increment() {
//    atomicInteger.incrementAndGet();
//  }
//
//  public int getCount() {
//    return atomicInteger.get();
//  }

//  private int count = 0;
//
//  public void increment() {
//    count++;
//  }
//
//  public int getCount() {
//    return count;
//  }

    private int count = 0;

  public synchronized void increment() {
    count++;
  }

  public synchronized int getCount() {
    return count;
  }

  public static void main(String[] args) throws Exception {

    Counter counter = new Counter();

    ExecutorService executor = Executors.newFixedThreadPool(10);

    for (int i = 0; i < 1000; i++) {
      executor.submit(counter::increment);
    }

    executor.shutdown();
    executor.awaitTermination(5, TimeUnit.SECONDS);

    System.out.println(counter.getCount());
  }
}
