package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
 * Main applicaytion class
 * 
 * Runs application and starts server. 
 * 
 * */
@ComponentScan({"com.gcu"})
@SpringBootApplication
public class RecruitATSApplication {

	/*
	 * entry point of application
	 * @param args Command-line arguments passed during application startup.
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(RecruitATSApplication.class, args);
	}

}
