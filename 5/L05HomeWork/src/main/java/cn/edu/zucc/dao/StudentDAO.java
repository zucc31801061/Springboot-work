package cn.edu.zucc.dao;

import cn.edu.zucc.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentDAO extends MongoRepository<Student, String> {
}
