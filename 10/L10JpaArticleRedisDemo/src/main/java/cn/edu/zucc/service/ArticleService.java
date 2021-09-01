package cn.edu.zucc.service;


import cn.edu.zucc.entity.Article;

import java.util.List;

public interface ArticleService {
    public List<Article> getArticleList();

    public Article findArticleById(long id);

}
