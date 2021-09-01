package com.dao;

import com.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentDAO extends MongoRepository<Student, String> {
}
