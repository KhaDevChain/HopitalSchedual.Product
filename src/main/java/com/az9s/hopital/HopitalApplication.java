package com.az9s.hopital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HopitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HopitalApplication.class, args);
	}

}
