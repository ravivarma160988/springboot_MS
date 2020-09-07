package com.wipro.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class AccountApplication {


	
	@GetMapping("/account")
	public String getAccount() {

		return "Account Api";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

}
