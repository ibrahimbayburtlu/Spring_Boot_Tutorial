package com.ibrahimbayburtlu.cruddemo;

import com.ibrahimbayburtlu.cruddemo.dao.AppDAO;
import com.ibrahimbayburtlu.cruddemo.entity.Course;
import com.ibrahimbayburtlu.cruddemo.entity.Instructor;
import com.ibrahimbayburtlu.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

			//deleteInstructorDetail(appDAO);

			// createInstructorWithCourse(appDAO);

			// findInstructorWithCourses(appDAO);

			// findCoursesForInstructor(appDAO);

			// findInstructorWithCoursesJoinFetch(appDAO);

			// updateInstructor(appDAO);
			// updateCourse(appDAO);
		};
	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;

		System.out.println("Finding instructor id:" + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Updating instructor id: " + theId);
		tempInstructor.setLastName("Tester");

		appDAO.updateInstructor(tempInstructor);

		System.out.println("Done!!!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("The associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!!!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 1;

		// find the instructor
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);

		// find courses for instructor
		List<Course> courses = appDAO.findCourseByInstructorId(theId);

		// associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("The associated courses: " + tempInstructor.getCourses());

	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("The associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!!!");
	}

	private void createInstructorWithCourse(AppDAO appDAO) {

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

		// create some courses
		Course tempCourse1 = new Course("footbal course One");

		Course tempCourse2 = new Course("footbal course Two");

		Course tempCourse3 = new Course("footbal course Three");

		// add courses to instructor

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		tempInstructor.add(tempCourse3);

		// save the instructor

		// NOTE : This will ALSO save the courses
		// because of CascadeType.PERSIST

		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done");
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
