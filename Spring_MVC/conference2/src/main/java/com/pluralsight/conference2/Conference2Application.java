package com.pluralsight.conference2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication //references application.properties
public class Conference2Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Conference2Application.class, args);
	}

}
