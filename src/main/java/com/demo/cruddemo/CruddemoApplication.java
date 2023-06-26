package com.demo.cruddemo;

import com.demo.cruddemo.dao.StudentDao;
import com.demo.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDAO){
		return runner -> {
			System.out.println("Hello World");
			//createStudent(studentDAO);
			//getStudentById(studentDAO);
			//getAllStudents(studentDAO);
			//getStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}


	private void createStudent(StudentDao studentDAO){
		System.out.println("Creating new Student object ...");
		Student tempStudent = new Student("Maria", "Moreno", "maria@some.com");
		System.out.println("Saving the student...");
		studentDAO.create(tempStudent);

		System.out.println("Saved student, Generated Id: " + tempStudent.getId());
	}

	private void getStudentById(StudentDao studentDAO){
		System.out.println("Find student with id :1 ");
		Student theStudent;
		theStudent = studentDAO.findById(1);
		System.out.println("The student is: " + theStudent);
	}

	private void getStudentByLastName(StudentDao studentDAO){
		List<Student> studentList = studentDAO.findByLastName("Moreno");
		for (Student theStudent : studentList){
			System.out.println(theStudent );
		}
	}

	private void getAllStudents(StudentDao studentDao){
		List<Student> studentList = studentDao.findAll();
 		for (Student theStudent : studentList){
			System.out.println(theStudent );
		}
	}

	private void updateStudent(StudentDao studentDAO) {
		// get student by id
		Student theStudent = studentDAO.findById(1);
		// change data of student
		theStudent.setLastName("Exposito");
		// save changes
		studentDAO.update(theStudent);

		System.out.println(theStudent.toString());

	}

	private void deleteStudent(StudentDao studentDAO) {
		System.out.println("delete student with id 1");
		studentDAO.delete(1);
	}

	private void deleteAllStudents(StudentDao studentDAO) {
		System.out.println("Delete All students");
		int rows = studentDAO.deleteAll();
		System.out.println("Deleted " + rows+ " students");
	}


}
