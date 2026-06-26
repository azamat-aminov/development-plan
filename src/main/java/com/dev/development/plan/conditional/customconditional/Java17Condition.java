package com.dev.development.plan.conditional.customconditional;

import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class Java17Condition implements Condition {

  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    return JavaVersion.getJavaVersion().equals(JavaVersion.SEVENTEEN);
  }
}
