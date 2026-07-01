package com.dev.development.plan.retry.resilience4j;


import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.time.Duration;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResilienceConfig {

  @Bean
  public RetryRegistry retryRegistry() {

    RetryConfig retryConfig = RetryConfig.custom()
        .maxAttempts(5)
        .waitDuration(Duration.ofSeconds(3))
        .retryExceptions(
            ConnectException.class,
            SocketTimeoutException.class
        )
        .ignoreExceptions(
            IllegalArgumentException.class
        )
        .build();

    return RetryRegistry.of(
        Map.of("productServiceRetry", retryConfig)
    );
  }
}
