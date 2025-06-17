package com.in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOrderServiceApplication.class, args);
	}

}
