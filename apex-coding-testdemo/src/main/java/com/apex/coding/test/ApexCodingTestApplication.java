package com.apex.coding.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.apex.coding.test")
public class ApexCodingTestApplication {
	public static void main(String[] args) {

		SpringApplication.run(ApexCodingTestApplication.class, args);
	}
}
