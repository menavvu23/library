package com.navneet.library.controller;

import com.navneet.library.model.Student;
import com.navneet.library.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping("/{id}")
    public Optional<Student> getByID(@PathVariable(value = "id") int id)
    {
        return studentService.getById(id);
    }

    @RequestMapping("/defaulters")
    public List<Student> defaulters()
    {
        return studentService.defaulters();
    }

    @RequestMapping(method = RequestMethod.POST,value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
    }
}
