package com.dev.development.plan.conditional.missingbean;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonMapperHelperConfig {

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

  @Bean
  @ConditionalOnMissingBean(value = ObjectMapper.class)
  public CustomObjectMapper customObjectMapper() {
    return new CustomObjectMapper();
  }

}
