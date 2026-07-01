package com.dev.development.plan.retry;

import java.net.ConnectException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class WeatherClient {

  private final RetryTemplate retryTemplate;

  public WeatherClient(RetryTemplate retryTemplate) {
    this.retryTemplate = retryTemplate;
  }


  @Retryable(value = ConnectException.class, maxAttempts = 2, backoff = @Backoff(delay = 3000))
  public String getForecast() throws ConnectException {
    log.info("weather forecast is processing....");
    // Pretend this reaches out to an external API
    throw new ConnectException("Connection failed");
  }

  @Recover
  public String recoverForecast(ConnectException ex) {
    return "Forecast service is not reachable/available: " + ex.getMessage();
  }

  public String getForecastRetryTemplate() throws ConnectException {
    return retryTemplate.execute(retryContext -> {
          log.info("weather forecast retry template is processing....");
          // Pretend this reaches out to an external API
          throw new ConnectException("Connection failed");
        },
        retryContext -> "Forecast service is not reachable/available");
  }
}
