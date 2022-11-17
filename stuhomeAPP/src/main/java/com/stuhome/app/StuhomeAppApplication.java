package com.stuhome.app;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class StuhomeAppApplication implements WebMvcConfigurer{

	public static void main(String[] args){
		
		SpringApplication.run(StuhomeAppApplication.class, args);
		
	}
	
}
