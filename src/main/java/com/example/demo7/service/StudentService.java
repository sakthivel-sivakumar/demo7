package com.example.demo7.service;

import com.example.demo7.entity.Student;
import org.springframework.stereotype.Service;
import com.example.demo7.repository.StudentRepository;

import java.util.Optional;

@Service
public class StudentService
{
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student obj) {
        return studentRepository.save(obj);
    }

    public Student getStudentById(Long id) {
        Optional<Student> s = studentRepository.findById(id);
        if (s.isPresent()) {
            return s.get();
        } else {
            return null;
        }
    }


    public Student editStudent(Long id, Student newData) {
        Optional<Student> s = studentRepository.findById(id);
        if (s.isPresent()) {
            Student stu = s.get();
            stu.setFirstName(newData.getFirstName());
            stu.setLastName(newData.getLastName());
        } else {
            return null;
        }

        return studentRepository.save(s.get());

    }

    public String deleteStudentById(Long id) {
        Optional<Student> s = studentRepository.findById(id);
        if (s.isPresent()) {
            studentRepository.deleteById(id);
            return "Deleted";
        } else {
            return "Invalid ID";
        }

    }
}