package com.example.StudentsManagementSystem.service;

import com.example.StudentsManagementSystem.modelo.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> listStudents();

    public Student findStudentById(Integer idStudent);

    public void saveStudent(Student student);

    public void deleteStudent(Student student);



}
