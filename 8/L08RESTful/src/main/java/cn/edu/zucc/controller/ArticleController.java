package cn.edu.zucc.controller;

import cn.edu.zucc.entity.Article;
import cn.edu.zucc.repository.ArticleRepository;
import cn.edu.zucc.result.ExceptionMsg;
import cn.edu.zucc.result.Response;
import cn.edu.zucc.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("article")
public class ArticleController {
    protected Response result(ExceptionMsg msg){
        return new Response(msg);
    }
    protected Response result(){
        return new Response();
    }

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseData getArticleList() {
        List<Article> list = new ArrayList<Article>(articleRepository.findAll());
        return new ResponseData(ExceptionMsg.SUCCESS,list);
    }

    //增
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseData add(Article article) {
        articleRepository.save(article);
        return new ResponseData(ExceptionMsg.SUCCESS,article);
    }

    //删
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable("id") long id) {
        articleRepository.deleteById(id);

        return result(ExceptionMsg.SUCCESS);
      }

    //改
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseData update(Article model) {
        articleRepository.save(model);
        return new ResponseData(ExceptionMsg.SUCCESS,model);
    }

    //查
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseData findArticle(@PathVariable("id") Integer id) throws IOException {
              Article article = articleRepository.findById(id);
        if (article != null) {
            return new ResponseData(ExceptionMsg.SUCCESS,article);
        }
        return new ResponseData(ExceptionMsg.FAILED,article);
    }

    //查
    @RequestMapping(value = "/re/{id}", method = RequestMethod.GET)
    public Article findArticled(@PathVariable("id") Integer id) throws IOException {
        RestTemplate client= restTemplateBuilder.build();
        String uri = "http://localhost:8080/article/"+id;
        System.out.println(uri);
        Article article = client.getForObject (uri,Article.class,id) ;

        return article;
    }
}


