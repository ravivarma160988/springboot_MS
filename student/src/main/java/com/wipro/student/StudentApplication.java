package com.wipro.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class StudentApplication {

	@GetMapping("/student")
	public String getStudent() {
		return "Student Api";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

}
