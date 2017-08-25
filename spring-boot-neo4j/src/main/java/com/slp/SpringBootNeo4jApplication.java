package com.slp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootNeo4jApplication extends SpringBootServletInitializer implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootNeo4jApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("初始化。。。。。。。。");
	}

	protected SpringApplicationBuilder config(SpringApplicationBuilder applicationBuilder){
	return applicationBuilder.sources(SpringBootNeo4jApplication.class);
	}
}
