package cn.edu.zucc.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private Integer id;
    private String name;
    private String number;
    private String email;
    private List<Resume> resumeList;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                ", resumeList=" + resumeList +
                '}';
    }
}
