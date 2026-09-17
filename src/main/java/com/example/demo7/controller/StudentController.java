package com.example.demo7.controller;

import com.example.demo7.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo7.service.StudentService;

@RestController
@RequestMapping("api/v1") // BASE URL
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student obj){
        return studentService.addStudent(obj);
    }
    @GetMapping("/find/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/edit/{id}")
    public Student editStudent(@PathVariable Long id , @RequestBody Student obj){
        return studentService.editStudent(id,obj);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
    }







}
