package com.example.StudentsManagementSystem;

import com.example.StudentsManagementSystem.modelo.Student;
import com.example.StudentsManagementSystem.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class StudentsManagementSystemApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;

	private static final Logger logger = LoggerFactory.getLogger(StudentsManagementSystemApplication.class);

	String nl = System.lineSeparator();

	public static void main(String[] args) {

		logger.info("Starting Application");

		SpringApplication.run(StudentsManagementSystemApplication.class, args);

		logger.info("Finished Application");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(nl + "Method run of Spring" + nl);
		var exit = false;
		var consola = new Scanner(System.in);
		while (!exit) {
			showMenu();
			exit = executeOptions(consola);
			logger.info(nl);
		}
	}

	private void showMenu(){
		logger.info(nl);
		logger.info("""
				*** Students System ***
				1. List Student
				2. Find Student
				3. Add Student
				4. Modify Student
				5. Delete Student
				6. Exit
				""");
	}

	private boolean executeOptions(Scanner consola){
		logger.info("Insert Option: ");
		var option = Integer.parseInt(consola.nextLine());
		var exit = false;
		switch (option){
			case 1 -> {
				logger.info(nl + "Students: " +nl);
				List<Student> students = studentService.listStudents();
				students.forEach((student ->logger.info(student.toString() + nl)));
			}
			case 2 -> {
				logger.info("Insert student Id: ");
				var idStudent = Integer.parseInt(consola.nextLine());
				Student student = studentService.findStudentById(idStudent);
				if(student != null)
					logger.info("Student found: " + student + nl);
				else
					logger.info("Student not found: " + student + nl);

			}
			case 3 -> {
				logger.info("Add Student: " + nl);
				logger.info("Name: ");
				var name = consola.nextLine();
				logger.info("Surname: ");
				var surname = consola.nextLine();
				logger.info("Phone: ");
				var phone = consola.nextLine();
				logger.info("Email: ");
				var mail = consola.nextLine();

				var student = new Student();
				student.setName(name);
				student.setSurname(surname);
				student.setPhone(phone);
				student.setMail(mail);
				studentService.saveStudent(student);
				logger.info("Added Student: " + student + nl);
			}
			case 4 ->{
				logger.info("Modify Student: " + nl);
				logger.info("Student Id: ");
				var idStudent = Integer.parseInt(consola.nextLine());
				Student student = studentService.findStudentById(idStudent);
				if(student != null){
					logger.info("Name: ");
					var name = consola.nextLine();
					logger.info("Surname: ");
					var surname = consola.nextLine();
					logger.info("Phone: ");
					var phone = consola.nextLine();
					logger.info("Mail: ");
					var mail = consola.nextLine();
					student.setName(name);
					student.setSurname(surname);
					student.setPhone(phone);
					student.setMail(mail);
					studentService.saveStudent(student);
					logger.info("Modified Student: " + student + nl);
				}
				else{
					logger.info("Student: " + idStudent + "Not foun");
				}
			}
			case 5 ->{
				logger.info("Delete Student: " + nl);
				logger.info("Id Student: ");
				var idStudent = Integer.parseInt(consola.nextLine());
				var student = studentService.findStudentById(idStudent);
				if(student != null){
					studentService.deleteStudent(student);
					logger.info("Student " + idStudent + " Has been removed" + nl);
				}
				else
					logger.info("Student " + idStudent + " Not found");
			}
			case 6 -> {
				logger.info("See you soon!" + nl + nl);
				exit = true;
			}
			default -> logger.info("Option: " + option + "Not valid" + nl);
		}
		return exit;
	}

}
