package com;
import com.example.config.User;
import com.example.repo.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;


@SpringBootApplication
public class SecurityServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityServerApplication.class, args);
	}

	@Bean
	public ApplicationRunner dataLoader(
			UserRepository repo, PasswordEncoder encoder) {
		return args -> {
			repo.save(
					new User("habuma", encoder.encode("password"), "ROLE_ADMIN"));
			repo.save(
					new User("tacochef", encoder.encode("password"), "ROLE_ADMIN"));
		};
	}

	@Bean
	public PasswordEncoder passwordEncoder (){
		return  new BCryptPasswordEncoder();
	}
}
