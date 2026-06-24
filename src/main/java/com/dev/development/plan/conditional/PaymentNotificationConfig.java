package com.dev.development.plan.conditional;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentNotificationConfig {

  @Bean
  @ConditionalOnProperty(prefix = "notification", name = "service", havingValue = "email")
  public PaymentNotificationSender emailNotificationSender() {
    return new PaymentEmailNotificationService();
  }

  @Bean
  @ConditionalOnProperty(prefix = "notification", name = "service", havingValue = "sms")
  public PaymentNotificationSender smsNotificationSender() {
    return new PaymentSMSNotificationService();
  }

}
