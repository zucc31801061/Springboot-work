package cn.edu.zucc.mapper;

import cn.edu.zucc.entity.Comment;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommentMapper {
    @Select("SELECT * FROM comment WHERE id =#{id}")
    public Comment findById(Integer id);

    @Insert("INSERT INTO comment(content,author,aid) " +
            "values (#{content},#{author},#{aId})")
    public int insertComment(Comment comment);

    @Update("UPDATE comment SET content=#{content} WHERE id=#{id}")
    public int updateComment(Comment comment);

    @Delete("DELETE FROM comment WHERE id=#{id}")
    public int deleteComment(Integer id);

}
