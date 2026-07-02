package com.dev.development.plan.redis;


import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/insert-user")
  public ResponseEntity<User> insertUser(@RequestBody UserRequest request) {
    return Optional.ofNullable(request).map(userService::insertUser)
        .map(ResponseEntity::ok)
        .orElseThrow(RuntimeException::new);
  }

  @GetMapping("/users/{userId}")
  public ResponseEntity<User> findUserByUserId(@PathVariable Long userId) {
    return Optional.ofNullable(userId).map(userService::findUserById)
        .map(ResponseEntity::ok)
        .orElseThrow(RuntimeException::new);
  }
}
