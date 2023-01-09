package com.masai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {
	
	
	@Bean
	public RestTemplate provideTemplate() {
		return new RestTemplate();
	}

}
