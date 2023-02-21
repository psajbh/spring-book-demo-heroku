package com.jhart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootDemoApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
//		System.out.print("current runtime version: ");
//		System.out.println(System.getProperty("java.runtime.version"));
//		
//		List<String> names = new ArrayList<>();
//		Set<String> propNames = System.getProperties().stringPropertyNames();
//		propNames.forEach(propertyName -> {
//			System.out.println(propertyName + "=" + System.getProperty(propertyName));
//		});
//		System.out.println(names);
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootDemoApplication.class);
	}
}
