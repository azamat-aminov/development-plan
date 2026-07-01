package com.dev.development.plan.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CancelTaskExample {

  public static void main(String[] args) throws Exception {
    ExecutorService executor = Executors.newFixedThreadPool(2);

    // Submit a long-running task
    Future<?> future = executor.submit(() -> {
      try {
        Thread.sleep(5000); // Simulate long-running task
        System.out.println("Task completed");
      } catch (InterruptedException e) {
        System.out.println("Task interrupted");
      }
    });

    // Attempt to cancel the task before it completes
    Thread.sleep(1000); // Let the task start
    boolean canceled = future.cancel(true);

    if (canceled) {
      System.out.println("Task was successfully canceled.");
    } else {
      System.out.println("Task could not be canceled.");
    }

    // Shutdown the executor
    executor.shutdown();
  }
}