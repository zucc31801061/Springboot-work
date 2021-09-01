package cn.edu.zucc.controller;

import cn.edu.zucc.entity.Student;
import cn.edu.zucc.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentMapper studentMapper;

    @RequestMapping("/")
    List<Student> queryAll() {
        return studentMapper.queryAll();
    }

    @RequestMapping("/add")
    public int add(Student student){
        return studentMapper.addStudent(student);
    }

    @RequestMapping("/delete")
    public int delete(Integer id){
        return studentMapper.deleteStudent(id);
    }

    @RequestMapping("/find")
    public Student find(Integer id){
        return studentMapper.findStudent(id);
    }

    @RequestMapping("/update")
    public int update(Student student){
        return studentMapper.updateStudent(student);
    }
}
