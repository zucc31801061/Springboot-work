package cn.edu.zucc.entity;

import lombok.Data;

@Data
public class Comment {
    private Integer id;
    private String content;
    private String author;
    private Integer aid;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", aId=" + aid +
                '}';
    }
}
