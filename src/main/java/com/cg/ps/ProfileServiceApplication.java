package com.cg.ps;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfileServiceApplication {

	public static Logger logger=LoggerFactory.getLogger(ProfileServiceApplication.class);
	
	@PostConstruct
	public void init() {
		logger.info("Application Started..");
	}
	public static void main(String[] args) {
		logger.info("Application executed..");
		SpringApplication.run(ProfileServiceApplication.class, args);
	}

}
