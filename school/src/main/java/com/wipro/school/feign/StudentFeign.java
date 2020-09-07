package com.wipro.school.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("STUDENT")
public interface StudentFeign {

	@GetMapping("/student")
	public String getStudent();
}
