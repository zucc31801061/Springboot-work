package cn.edu.zucc.mapper;

import cn.edu.zucc.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentMapper {
    public List<Student> queryAll();
    public int addStudent(Student student);
    public int deleteStudent(Integer id);
    public Student findStudent(Integer id);
    public int updateStudent(Student student);
}
