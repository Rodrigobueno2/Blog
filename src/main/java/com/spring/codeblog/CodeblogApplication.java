package com.spring.codeblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.spring.codeblog.configuration.SecurityConfig;

@SpringBootApplication
public class CodeblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeblogApplication.class, args);
	}

}
