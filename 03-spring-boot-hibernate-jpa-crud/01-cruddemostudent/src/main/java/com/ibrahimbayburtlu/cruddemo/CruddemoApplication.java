package com.ibrahimbayburtlu.cruddemo;

import com.ibrahimbayburtlu.cruddemo.dao.StudentDAO;
import com.ibrahimbayburtlu.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			// createStudent(studentDAO);

			// createMultipleStudent(studentDAO);

			// readStudent(studentDAO);

			// queryForStudent(studentDAO);

			queryForStudentsByLastName(studentDAO);
		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Duck");

		// display list of students
		for (Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {

		// get list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student Object...");
		Student tempStudent = new Student("Daffy","Duck","daffyDuck@gmail.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: "+tempStudent.getId());

		// retrieve student based on the id: primary key
		System.out.println("\nRetrieving student with id:" + tempStudent.getId());

		Student myStudent = studentDAO.findById(tempStudent.getId());

		System.out.println("Found the student: "+myStudent);

	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		// create multiple student
		System.out.println("Creating 3 student object ....");
		Student tempStudent1 = new Student("Murat","Teknosa","muratTeknosa@gmail.com");
		Student tempStudent2 = new Student("Zehra","Teknosa","zehraTeknosa@gmail.com");
		Student tempStudent3 = new Student("Orçun","Teknosa","orçunTeknosa@gmail.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ....");
		Student tempStudent = new Student("Paul","Doe","ibrahimbayburtlu5@gmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id:" + tempStudent.getId());
	}
}
