package com.service;

import com.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getStudentList();
    public Student findStudentById(long id);
}
