package com.dxctraining.inventorymgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootapplication equivalent to 3 things
 * 1)@Configuration : so we don't have to provide on our own
 * 2)@ComponentScan: so we don't have to provide on our own
 * 3) @AutoConfiguration so we don't have to provide on our own
 */
@SpringBootApplication
public class ProjectMain {

	public static void main(String[] args) {
		SpringApplication.run(ProjectMain.class, args);
	}

}
