package cn.edu.zucc;

import cn.edu.zucc.entity.Article;
import cn.edu.zucc.entity.Comment;
import cn.edu.zucc.mapper.ArticleMapper;
import cn.edu.zucc.mapper.CommentMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class L07MybatisCurdApplicationTests {

    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void selectComment() {
        Comment comment = commentMapper.findById(1);
        System.out.println(comment);
    }

    @Autowired
    private ArticleMapper articleMapper;
    @Test
    public void selectArticle() {
        Article article = articleMapper.selectArticle(1);
        System.out.println(article);
    }

    //测试更新文章
    @Test
    public void updateArticle(){
        Article a=new Article();
        a.setId(1);
        a.setTitle("a_modify");
        a.setContent("c_modify");
        int result = articleMapper.updateArticle(a);
        System.out.println(result);
    }
}
