package cn.edu.zucc.config;
import cn.edu.zucc.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean("user1")
    public User user() {
        User user = new User();
        user.setId(1);
        user.setName("xxx");
        return user;
    }

}
