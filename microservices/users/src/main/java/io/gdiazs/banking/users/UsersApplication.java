package io.gdiazs.banking.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.gdiazs.commons.boot.security.annotation.EnableCommonsJwtSecurity;

@EnableCommonsJwtSecurity
@SpringBootApplication
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

}

