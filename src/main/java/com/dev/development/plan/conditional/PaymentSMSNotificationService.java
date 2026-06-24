package com.dev.development.plan.conditional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentSMSNotificationService implements PaymentNotificationSender {

  @Override
  public String sendNotification(String message) {
    log.info("send SMS notification: " + message);
    return "SMS notification: " + message;
  }
}
