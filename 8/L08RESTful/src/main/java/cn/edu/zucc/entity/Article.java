package cn.edu.zucc.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "artitcle")
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String body;
}
