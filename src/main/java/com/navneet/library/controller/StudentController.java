package com.navneet.library.controller;

import com.navneet.library.model.Student;
import com.navneet.library.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping("/students/{id}")
    public Optional<Student> getByID(@PathVariable(value = "id") int id)
    {
        return studentService.getById(id);
    }


    @RequestMapping(method = RequestMethod.POST,value = "/students")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
    }


}
