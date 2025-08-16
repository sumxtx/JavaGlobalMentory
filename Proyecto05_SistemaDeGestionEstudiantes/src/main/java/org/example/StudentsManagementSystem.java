package org.example;

import org.example.datos.StudentDAO;
import org.example.dominio.Student;

import javax.crypto.spec.PSource;
import java.util.Scanner;

public class StudentsManagementSystem {
    public static void main(String[] args) {
        var exit = false;
        var consola = new Scanner(System.in);
        var studentDao = new StudentDAO();
        while (!exit) {
            try {
                showMenu();
                exit = executeOptions(consola, studentDao);
            } catch (Exception e){
                System.out.println("An error occurred at: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static boolean executeOptions(Scanner consola, StudentDAO studentDao) {
        System.out.print(">> ");
        var option = Integer.parseInt(consola.nextLine());
        var exit = false;
        switch (option) {
            case 1 ->{
                System.out.println("Students: ");
                var students = studentDao.listStudents();
                students.forEach(System.out::println);
            }
            case 2 ->{
                System.out.println("Introduce Student Id:");
                System.out.print(">> ");
                var idStudent = Integer.parseInt(consola.nextLine());
                var student = new Student(idStudent);
                var found = studentDao.findStudentByID(student);
                if(found)
                    System.out.println("Student Found: " + student);
                else
                    System.out.println("Student Not Found: " + student);
            }
            case 3 ->{
                System.out.println("Add Student");
                System.out.print("Name: ");
                var name = consola.nextLine();
                System.out.print("Surname: ");
                var surname = consola.nextLine();
                System.out.print("Phone: ");
                var phone = consola.nextLine();
                System.out.print("Mail: ");
                var mail = consola.nextLine();
                var student = new Student(name, surname, phone, mail);
                var addStudent = studentDao.insertStudent(student);
                if (addStudent)
                    System.out.println("Successfullly added student: " + student);
                else
                    System.out.println("Failed to add student");
            }
            case 4 -> {
                System.out.println("Modify Student");
                System.out.print("Id Student: ");
                var idStudent = Integer.parseInt(consola.nextLine());
                System.out.print("Name: ");
                var name = consola.nextLine();
                System.out.print("Surname: ");
                var surname = consola.nextLine();
                System.out.print("Phone: ");
                var phone = consola.nextLine();
                System.out.print("Mail: ");
                var mail = consola.nextLine();
                var student = new Student(idStudent, name, surname, phone, mail);
                var modified = studentDao.modifyStudent(student);
                if(modified)
                    System.out.println("Successfully Modified Student: " + student);
                else
                    System.out.println("Failed to Modify Student: " + student);

            }
            case 5 -> {
                System.out.println("Remove Student: ");
                System.out.print("Id Student: ");
                var idStudent = Integer.parseInt(consola.nextLine());
                var student = new Student(idStudent);
                var removed = studentDao.deleteStudent(student);
                if (removed)
                    System.out.println("Removed Student");
                else
                    System.out.println("Failed to remove Student");

            }
            case 6 ->{
                System.out.println("See you soon");
                exit = true;
            }
            default -> System.out.println("Option not set");
        }
        return exit;

    }

    private static void showMenu() {
        System.out.println("""
                *** Students Management System ***
                1. List Students
                2. Find Student By Id
                3. Add Student
                4. Modify Student
                5. Delete Student
                6. Exit                
                """);
    }
}