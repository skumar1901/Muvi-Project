package com.muvi.solution.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.muvi.solution")
public class AppMain {
	public static void main(String[] args) {
		SpringApplication.run(AppMain.class, args);
    }
}
