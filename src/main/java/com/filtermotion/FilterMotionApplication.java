package com.filtermotion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FilterMotionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilterMotionApplication.class, args);
	}

}
