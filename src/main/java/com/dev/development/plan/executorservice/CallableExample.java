package com.dev.development.plan.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

  public static void main(String[] args) throws Exception {
    ExecutorService executor = Executors.newFixedThreadPool(2);

    // Submit a Callable task that returns a value
    Future<Integer> future = executor.submit(new Callable<Integer>() {
      @Override
      public Integer call() {
        return 42; // Task returns the number 42
      }
    });

    // Wait for the result
    System.out.println("Result of the task: " + future.get());

    // Shutdown the executor
    executor.shutdown();
  }
}
