package cn.edu.zucc.mapper;

import cn.edu.zucc.entity.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentMapper {
    //列表
    @Select("SELECT * FROM student WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "number", column = "number"),
            @Result(property = "email", column = "email")
    })
    public List<Student> queryAll();
    //增加
    @Insert("INSERT INTO student(id,name,number,email) VALUES (#{id},#{name},#{number},#{email})")
    public int addStudent(Student student);
    //删除
    @Delete("DELETE FROM student where id = #{id}")
    public int deleteStudent(Integer id);
    //查询
    @Select("SELECT student.*,resume.id,resume.content,resume.s_id FROM student,resume WHERE student.id=resume.s_id AND student.id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "number", column = "number"),
            @Result(property = "email", column = "email"),
            @Result(property="resumeList",column="id",
                many = @Many(select = "cn.edu.zucc.mapper.ResumeMapper.findResumeBySid",fetchType = FetchType.LAZY)
            )
    })
    public Student findStudent(Integer id);
    //修改
    @Update("UPDATE student SET name=#{name},number=#{number},email=#{email} WHERE id=#{id}")
    public int updateStudent(Student student);
}
