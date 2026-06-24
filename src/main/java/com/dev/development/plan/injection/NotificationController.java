package com.dev.development.plan.injection;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Notification Service", description = "NF service for internal use.")
public class NotificationController {

  private final Map<String, NotificationService> notificationService;

  public NotificationController(Map<String, NotificationService> notificationService) {
    this.notificationService = notificationService;
  }

  @PostMapping("/send-sms-notification")
  @Operation(method = "POST", description = "Enables to send SMS notifications")
  public ResponseEntity<String> sendNotification(@RequestBody String notification) {
    return Optional.ofNullable(notification)
        .map(notify -> notificationService.get("smsService")
            .sendNotification(notify))
        .map(ResponseEntity::ok)
        .orElseThrow(RuntimeException::new);
  }
}
