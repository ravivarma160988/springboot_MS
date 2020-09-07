package com.wipro.student.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ReqScopeExp {
	
	private String name = "Request Scope";
	
	public ReqScopeExp() {
		System.out.println("DataRequestScope Constructor Called");
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
