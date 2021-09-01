package com.service;

import com.dao.StudentDAO;
import com.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    StudentDAO studentDAO;

    @Override
    public ArrayList<Student> findAll(){
        return (ArrayList<Student>) studentDAO.findAll();
    }

    @Override
    public void addData(Student stu){
        studentDAO.save(stu);
    }

    @Override
    public void removeData(String id){
        //Student student = mongoTemplate.findById(id, Student.class);
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Student.class);
    }

    @Override
    public Student findById(String id){
        Query query = new Query(Criteria.where("id").is(id));
        Student student = mongoTemplate.findOne(query, Student.class);
        return student;
    }

    @Override
    public void updateData(Student student){
        Query query = new Query(Criteria.where("id").is(student.getId()));
        Update update = new Update().set("name",student.getName()).set("id",student.getId()).set("email",student.getEmail()).set("cardId",student.getCardId()).set("sex",student.getSex());
        mongoTemplate.updateFirst(query,update,Student.class);
    }
}
