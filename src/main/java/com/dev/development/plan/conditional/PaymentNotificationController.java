package com.dev.development.plan.conditional;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Payment Notification Service", description = "PNF service for internal use.")
public class PaymentNotificationController {

  private final PaymentNotificationSender notificationSender;

  public PaymentNotificationController(PaymentNotificationSender notificationSender) {
    this.notificationSender = notificationSender;
  }

  @PostMapping("/send-notification")
  @Operation(method = "POST", description = "Enables to send notifications")
  public ResponseEntity<String> sendNotification(@RequestBody String notification) {
    return Optional.ofNullable(notification)
        .map(notificationSender::sendNotification)
        .map(ResponseEntity::ok)
        .orElseThrow(RuntimeException::new);
  }
}
