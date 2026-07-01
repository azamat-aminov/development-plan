package com.dev.development.plan.retry.resilience4j;


import java.net.ConnectException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("/process-product-payment")
  public String processProductPayment(@RequestBody Integer amount) throws ConnectException {
    return productService.processProductPayment(amount);
  }
}
