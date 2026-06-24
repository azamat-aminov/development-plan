package com.dev.development.plan.injection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("emailService")
@Slf4j
public class EmailNotificationService implements NotificationService{

  @Override
  public String sendNotification(String message) {
    log.info("sent email notification:" + message);
    return message;
  }
}
