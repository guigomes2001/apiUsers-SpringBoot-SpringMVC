package com.users.apiUsers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.apiUsers.controllers, com.apiUsers.services" )
public class ApiUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiUsersApplication.class, args);
	}

}
