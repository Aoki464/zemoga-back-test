package com.zemogaback.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan({"com.zemogaback"})
@EntityScan("com.zemogaback.entities")
@EnableTransactionManagement
public class ZemogaBackendTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZemogaBackendTestApplication.class, args);
	}

}
