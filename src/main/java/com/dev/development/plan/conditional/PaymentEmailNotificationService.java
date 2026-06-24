package com.dev.development.plan.conditional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentEmailNotificationService implements PaymentNotificationSender {

  @Override
  public String sendNotification(String message) {
    log.info("sent email notification:" + message);
    return "EMAIL notification: " + message;
  }
}
