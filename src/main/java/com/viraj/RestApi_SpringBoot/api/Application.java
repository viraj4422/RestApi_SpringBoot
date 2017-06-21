package com.viraj.RestApi_SpringBoot.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.viraj.RestApi_SpringBoot.api.configuration.SwaggerConfig;
import com.viraj.RestApi_SpringBoot.api.configuration.WebConfig;

@SpringBootApplication
@Import({SwaggerConfig.class,WebConfig.class})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
