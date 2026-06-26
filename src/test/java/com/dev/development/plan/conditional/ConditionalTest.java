package com.dev.development.plan.conditional;


import static org.junit.jupiter.api.Assertions.assertThrows;

import com.dev.development.plan.conditional.missingbean.CustomObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ConditionalTest {

  @Autowired
  ApplicationContext context;

  @Test
  void conditionalTest() {
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> context.getBean(CustomObjectMapper.class));
  }

}
