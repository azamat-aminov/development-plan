package com.dev.development.plan.conditional.customconditional;


import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Service
@Conditional(Java17Condition.class)
public class Java17DependedService {

    //Java 17 compatible service, The bean is created only if the Java version is 17
}
