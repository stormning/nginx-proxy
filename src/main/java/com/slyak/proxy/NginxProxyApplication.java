package com.slyak.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NginxProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(NginxProxyApplication.class, args);
	}
}
