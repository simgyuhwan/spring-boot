package com.toby.boot;

import com.toby.boot.annotation.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
public class BootApplication {
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

}
