package com.dev.development.plan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
@EnableCaching
public class DevelopmentPlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevelopmentPlanApplication.class, args);
	}

}
