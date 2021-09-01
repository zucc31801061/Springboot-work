package cn.edu.zucc.service.impl;

import cn.edu.zucc.entity.Article;
import cn.edu.zucc.repository.ArticleRepository;
import cn.edu.zucc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "articleService")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getArticleList() {
        return articleRepository.findAll();
    }

    @Override
    @Cacheable(key ="#p0")
    public Article findArticleById(long id) {
        return articleRepository.findById(id);
    }
}

