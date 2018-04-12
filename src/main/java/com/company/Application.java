package com.company;

import com.company.controller.DefaultController;
import com.company.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories("com.company")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		DefaultController defaultController = new DefaultController();
		defaultController.homePage();

	}
}
