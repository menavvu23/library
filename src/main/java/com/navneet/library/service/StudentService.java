package com.navneet.library.service;

import com.navneet.library.model.Student;
import com.navneet.library.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    public Optional<Student> getById(int id) {
        return studentRepository.findById(id);
    }



    public void addStudent(Student student) {
        studentRepository.save(student);
    }
}
