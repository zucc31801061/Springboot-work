package cn.edu.zucc.mapper;

import cn.edu.zucc.entity.Resume;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ResumeMapper {
    public Resume findResume(Integer id);
    public int addResume(Resume resume);
    public int updateResume(Resume resume);
    public int deleteResume(Integer id);
}
