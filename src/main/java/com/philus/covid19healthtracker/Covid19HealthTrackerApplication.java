package com.philus.covid19healthtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Covid19HealthTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19HealthTrackerApplication.class, args);
	}

}
