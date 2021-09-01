package cn.edu.zucc;

import cn.edu.zucc.entity.Resume;
import cn.edu.zucc.entity.Student;
import cn.edu.zucc.mapper.ResumeMapper;
import cn.edu.zucc.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@MapperScan("cn.edu.zucc.mapper")
@SpringBootTest
public class L07HomeworkByAnnotationsApplicationTests {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    //增加
    public void addStudent(){
        Student s=new Student();
        s.setId(4);
        s.setName("wls");
        s.setNumber("31801061");
        s.setEmail("123456@qq.com");
        System.out.println(studentMapper.addStudent(s));
    }

    @Test
    //删除
    public void deleteStudent(){
        System.out.println(studentMapper.deleteStudent(3));
    }

    @Test
    //查找
    public void findStudent(){
        Student student = studentMapper.findStudent(1);
        System.out.println(student);
    }

    @Test
    //查找
    public void updateStudent(){
        Student a=new Student();
        a.setId(2);
        a.setName("modify");
        a.setNumber("31801000");
        a.setEmail("000000@qq.com");
        System.out.println(studentMapper.updateStudent(a));
    }

    @Autowired
    private ResumeMapper resumeMapper;

    @Test
    //增加
    public void addResume(){
        Resume r=new Resume();
        r.setId(3);
        r.setContent("**");
        r.setSid(3);
        System.out.println(resumeMapper.addResume(r));
    }

    @Test
    //删除
    public void deleteResume(){
        System.out.println(resumeMapper.deleteResume(1));
    }

    @Test
    //查找
    public void findResume(){
        Resume resume = resumeMapper.findResume(1);
        System.out.println(resume);
    }

    @Test
    //查找
    public void updateResume(){
        Resume r=new Resume();
        r.setId(2);
        r.setContent("2_modify");
        System.out.println(resumeMapper.updateResume(r));
    }
}
