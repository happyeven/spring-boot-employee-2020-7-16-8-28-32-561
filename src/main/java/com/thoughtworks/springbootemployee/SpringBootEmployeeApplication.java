package com.thoughtworks.springbootemployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class SpringBootEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeApplication.class, args);
	}

}
