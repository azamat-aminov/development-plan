package com.dev.development.plan.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableExample {

  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(2);

    // Submit a simple Runnable task
    Future<?> future = executor.submit(() -> {
      System.out.println("Executing Task...");
    });

    // Check if task is done
    if (!future.isDone()) {
      System.out.println("Task is still in progress...");
    }
    // Shutdown the executor
    executor.shutdown();

  }
}
