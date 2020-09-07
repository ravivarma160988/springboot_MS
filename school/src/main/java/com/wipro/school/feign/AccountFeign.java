package com.wipro.school.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("ACCOUNT")
public interface AccountFeign {
	
	@GetMapping("/account")
	public String getAccount();

}
