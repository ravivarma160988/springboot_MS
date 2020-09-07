package com.wipro.springconfigclient.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.springconfigclient.model.DbConfig;

@RestController
@RefreshScope
public class HomeController {
	
	@Autowired
	private DbConfig dbConfig;
	
	@Value("${server.port}")
	private int server;
	
	@Value("${data.connection.location}")
	private String locaiton;
	
	@Value("${data.list}")
	private List<String> listUser;
	
	@Value("#{${data.maplist}}")
	private Map<String, String> mapDetails;
	
	@Value("hello")
	private String server_uri;
	
	@RequestMapping("/greetings")
	public String greetings() {
		return dbConfig.getConnection()+" : "+dbConfig.getHost() + " : "+dbConfig.getPort();
	}

	@RequestMapping("/home")
	public String home() {
		return server+" "+locaiton+" : "+server_uri;
	}
	
	@RequestMapping("/users")
	public String getUsers() {
		return listUser+" "+mapDetails;
	}
}
