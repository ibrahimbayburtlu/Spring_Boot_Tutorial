package com.ibrahimbayburtlu.aopdemo;

import com.ibrahimbayburtlu.aopdemo.dao.AccountDAO;
import com.ibrahimbayburtlu.aopdemo.dao.MembershipDAO;
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
	public CommandLineRunner commandLineRunner(AccountDAO theAccaountDAO, MembershipDAO theMembershipDAO){
		return runner -> {

			demoTheBeforeAdvice(theAccaountDAO,theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccaountDAO,MembershipDAO theMembershipDAO) {

		// call the business method
		theAccaountDAO.addAccount();

		// call the membership business method
		theMembershipDAO.addAccount();
		
	}
}
