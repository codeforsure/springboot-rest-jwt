package com.SpringRestHibernate.SpringRestHibernateExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RegisterApplication {
	
	public static void main(String args[]) {
		SpringApplication.run(RegisterApplication.class, args);
	}
}
