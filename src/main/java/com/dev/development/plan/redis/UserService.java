package com.dev.development.plan.redis;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User insertUser(UserRequest userRequest) {
    User user = new User(userRequest.userName(), userRequest.phoneNumber());
    return userRepository.save(user);
  }

  @Cacheable("users")
  public User findUserById(Long id) {
    log.info("Database call to retrieve a user by ID: {}", id);
    return userRepository.findById(id).orElseThrow(RuntimeException::new);
  }

  @CacheEvict(value = "users", key = "#id")
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
