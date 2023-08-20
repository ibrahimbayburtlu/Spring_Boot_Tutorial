package com.ibrahimbayburtlu.aopdemo;

import com.ibrahimbayburtlu.aopdemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccaountDAO){
		return runner -> {

			demoTheBeforeAdvice(theAccaountDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccaountDAO) {

		// call the business method
		theAccaountDAO.addAccount();

		// do it again!
		System.out.println("let's call it again!");

		// call the business method again
		theAccaountDAO.addAccount();
	}
}
