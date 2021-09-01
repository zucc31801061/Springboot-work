package cn.edu.zucc.entity;

import lombok.Data;

@Data
public class Resume {
    private Integer id;
    private String content;
    private Integer sid;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", aId=" + sid +
                '}';
    }
}
