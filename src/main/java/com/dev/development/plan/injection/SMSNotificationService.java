package com.dev.development.plan.injection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("smsService")
public class SMSNotificationService implements NotificationService {

  @Override
  public String sendNotification(String message) {
    log.info("send SMS notification: " + message);
    return message;
  }
}
