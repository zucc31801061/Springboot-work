package cn.edu.zucc.mapper;

import cn.edu.zucc.entity.Resume;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ResumeMapper {
    //查询
    @Select("SELECT * FROM resume WHERE id = #{id}")
    public Resume findResume(Integer id);
    //增加
    @Insert("INSERT INTO resume(id,content,s_id) VALUES (#{id},#{content},#{sid})")
    public int addResume(Resume resume);
    //修改
    @Update("UPDATE resume SET content=#{content} WHERE id=#{id}")
    public int updateResume(Resume resume);
    //删除
    @Delete("DELETE FROM resume WHERE id=#{id}")
    public int deleteResume(Integer id);

    //通过学生id查询
    @Select("SELECT * FROM resume WHERE s_id = #{id}")
    public Resume findResumeBySid(Integer id);
}
