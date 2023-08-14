package com.ibrahimbayburtlu.cruddemo;

import com.ibrahimbayburtlu.cruddemo.dao.AppDAO;
import com.ibrahimbayburtlu.cruddemo.entity.Instructor;
import com.ibrahimbayburtlu.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner -> {
			createInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {

		/*
		// create the instructor
		Instructor tempInstructor =
				new Instructor("ibo","bayburtlu","ibobayburtlu@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.ibrahim.com/youtube",
						"Football");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		*/

		Instructor tempInstructor =
				new Instructor("Madhu","Patel","madhuPatel@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.madhu.com/youtube",
						"Basketball");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		// save the instructor
		// NOTE : this will ALSO save the details object
		// because off CascadeType.ALL
		System.out.println("Saving Instructor: " + tempInstructorDetail);
		appDAO.save(tempInstructor);

		System.out.println("DONE!!!");

	}
}
