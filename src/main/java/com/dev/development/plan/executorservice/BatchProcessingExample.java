package com.dev.development.plan.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BatchProcessingExample {

  public static void main(String[] args) throws Exception {
    ExecutorService executor = Executors.newFixedThreadPool(4);
    List<Future<Integer>> futures = new ArrayList<>();

    // Submit multiple tasks for batch processing
    for (int i = 0; i < 10; i++) {
      final int taskId = i;
      futures.add(executor.submit(() -> {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Processing task " + taskId);
        return taskId * 2; // Simulated task processing
      }));
    }

    // Collect the results
    for (Future<Integer> future : futures) {
      System.out.println("Result: " + future.get());
    }

    // Shutdown the executor
    executor.shutdown();
  }
}
