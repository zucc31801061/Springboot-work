package com.service;

import com.entity.Student;

import java.util.ArrayList;

public interface StudentService {
    ArrayList<Student> findAll();

    void addData(Student stu);

    void removeData(String id);

    Student findById(String id);

    void updateData(Student student);
}
