package com.example.StudentsManagementSystem.service;

import com.example.StudentsManagementSystem.modelo.Student;
import com.example.StudentsManagementSystem.repositorio.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    @Autowired
    private IStudentRepo studentRepo;

    @Override
    public List<Student> listStudents() {
        List<Student> students = studentRepo.findAll();
        return students;
    }

    @Override
    public Student findStudentById(Integer idStudent) {
        Student student = studentRepo.findById(idStudent).orElse(null);
        return student;
    }

    @Override
    public void saveStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepo.delete(student);
    }
}
