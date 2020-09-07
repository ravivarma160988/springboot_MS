package com.wipro.school;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wipro.school.feign.AccountFeign;
import com.wipro.school.feign.StudentFeign;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
public class SchoolApplication {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AccountFeign accountFeign;
	
	@Autowired
	private StudentFeign studentFeign;
	
	@GetMapping("/school")
	public List<String> getSchool() {
		
		List<String> apiList = new ArrayList<String>();
		
//		restTemplate.delete(url);(3)
//		restTemplate.exchange(requestEntity, responseType);(8)
//		restTemplate.getForEntity(url, responseType);
//		restTemplate.getForObject(url, responseType);
//		restTemplate.put(url, request, uriVariables);
//		restTemplate.patchForObject(url, request, responseType);
//		restTemplate.postForEntity(url, request, responseType);
//		restTemplate.postForLocation(url, request);
//		restTemplate.postForObject(url, request, responseType);
//		restTemplate.execute(url, method, requestCallback, responseExtractor);(3)
		
//		String account = restTemplate.getForObject("http://ACCOUNT/account", String.class);
//		
//		String student = restTemplate.getForObject("http://STUDENT/student", String.class);
		
		String account = accountFeign.getAccount();
		
		String student = studentFeign.getStudent();
				
		apiList.add(account);
		apiList.add(student);
		apiList.add("School Api");
		
		Optional<String> min = apiList.parallelStream().min((e1,e2)->e1.compareTo(e2));
		apiList.add(min.get());
		
		Optional<String> max = apiList.parallelStream().max((e1,e2)->e1.compareTo(e2));
		apiList.add(max.get());
		
		return apiList;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}

}
