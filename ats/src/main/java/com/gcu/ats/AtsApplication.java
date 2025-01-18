package com.gcu.ats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.gcu"})
@SpringBootApplication
public class AtsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtsApplication.class, args);
	}

}
