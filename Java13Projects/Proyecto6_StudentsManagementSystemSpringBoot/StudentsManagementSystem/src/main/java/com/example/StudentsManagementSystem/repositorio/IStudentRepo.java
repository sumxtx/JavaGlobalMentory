package com.example.StudentsManagementSystem.repositorio;

import com.example.StudentsManagementSystem.modelo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends JpaRepository<Student, Integer> {

}
