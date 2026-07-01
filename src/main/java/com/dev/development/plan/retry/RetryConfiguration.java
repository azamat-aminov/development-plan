package com.dev.development.plan.retry;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@Configuration
public class RetryConfiguration {

  @Bean
  public RetryTemplate retryTemplate() {
    RetryTemplate retryTemplate = new RetryTemplate();

    SimpleRetryPolicy policy = new SimpleRetryPolicy();
    policy.setMaxAttempts(4); // total of 4 tries

    FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
    backOffPolicy.setBackOffPeriod(2000); // 2 seconds

    retryTemplate.setRetryPolicy(policy);
    retryTemplate.setBackOffPolicy(backOffPolicy);

    return retryTemplate;
  }

}
