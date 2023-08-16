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
			// createInstructor(appDAO);

			// findInstructor(appDAO);
			//deleteInstructor(appDAO);

			// findInstructorDetail(appDAO);

			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 4;
		System.out.println("Deleting instructor detail id: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done!!!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		int theId = 3;
		System.out.println("Finding instructor detail id: "+ theId);

		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println("tempInstructorDetail: " + tempInstructorDetail);
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id: "+ theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+ tempInstructor);

		appDAO.deleteInstructorById(theId);

		System.out.println(tempInstructor.getFirstName() + " instructor deleted");

	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 2;
		System.out.println("Finding instructor id: "+ theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+ tempInstructor);
		System.out.println("The associate InstructorDetail only: " + tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {


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

		appDAO.save(tempInstructor);

		tempInstructor =
				new Instructor("Madhu","Patel","madhuPatel@gmail.com");

		// create the instructor detail
		tempInstructorDetail =
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
