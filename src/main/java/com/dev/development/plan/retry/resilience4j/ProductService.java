package com.dev.development.plan.retry.resilience4j;


import io.github.resilience4j.core.functions.CheckedSupplier;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import java.net.ConnectException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ProductService {

  private final RestTemplate restTemplate = new RestTemplate();

  private final Retry retry;

  public ProductService(RetryRegistry retryRegistry) {
    this.retry = retryRegistry.retry("productRetry", "productServiceRetry");
  }

  //  @Retry(name = "productServiceRetry", fallbackMethod = "fallbackProductPayment")
  public String processProductPayment(Integer amount) throws ConnectException {
    CheckedSupplier<String> supplier =
        Retry.decorateCheckedSupplier(retry, () -> {
          log.info("Product payment is in progress with amount: {}", amount);
          throw new ConnectException("Connection failed");
        });

    try {
      return supplier.get();
    } catch (Throwable e) {
      return recover(amount, e);
    }
//    return restTemplate.getForObject("http:localhost:8082/product/payment", String.class);
  }

  private String recover(Integer amount, Throwable ex) {
    log.error("All retry attempts exhausted.", ex);

    return "Payment service unavailable.";
  }

  /**
   * Fallback Method Rules: 1. Must live in the same class. 2. Must have the exact same return type
   * and method parameters. 3. Must accept an extra trailing Exception parameter to capture the
   * error.
   */
  public String fallbackProductPayment(Integer amount, Exception exception) {
    log.info("All retry attempts exhausted. Triggering fallback with amount: " + amount);
    return "Fallback response: Payment provider is currently down. Please try again later.";
  }

}
