package com.demo.cruddemo;

import com.demo.cruddemo.dao.StudentDAO;
import com.demo.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			System.out.println("Hello World");
			createStudent(studentDAO);
		};
	}
	private void createStudent(StudentDAO studentDAO){
		System.out.println("Creating new Student object ...");
		Student tempStudent = new Student("Maria", "Moreno", "maria@some.com");
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student, Generated Id: " + tempStudent.getId());
	}
}
