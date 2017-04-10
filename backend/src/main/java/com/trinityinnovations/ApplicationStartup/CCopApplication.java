package com.trinityinnovations.ApplicationStartup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@Import(AppConfig.class)
@SpringBootApplication(scanBasePackages={"com.trinityinnovations.ApplicationStartup", "com.trinityinnovations.MoCoData", "com.trinityinnovations.PopulateMySQL"})
public class CCopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CCopApplication.class, args);
	}
}
