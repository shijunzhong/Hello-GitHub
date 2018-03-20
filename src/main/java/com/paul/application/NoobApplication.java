package com.paul.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan("com.paul.**")
@MapperScan("com.paul.dao.**")
public class NoobApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoobApplication.class, args);
	}
}
