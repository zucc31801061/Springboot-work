package cn.edu.zucc.module.Schedule;

import cn.edu.zucc.repository.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CountScheduledTasksTest {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void syncViews() {
        Long startTime = System.nanoTime();
        List dtoList = new ArrayList<>();
        Set<String> keySet = stringRedisTemplate.keys("name::*");
        for (String key : keySet) {
            String views = stringRedisTemplate.opsForValue().get(key);
            String sid = key.replaceAll("name::", "");
            long lid = Long.parseLong(sid);
            long lviews = Long.parseLong(views);
            //批量更新可以用Collection<?>大家可以研究下
            articleRepository.updateArticleViewById(lviews, lid);
            //删除key
            stringRedisTemplate.delete(key);
        }
    }

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void test(){
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("test","success");
        String test = valueOperations.get("test");
        System.out.println(test);
    }
}
