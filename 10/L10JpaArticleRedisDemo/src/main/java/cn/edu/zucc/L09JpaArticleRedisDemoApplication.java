package cn.edu.zucc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EnableCaching
@SpringBootApplication
public class L09JpaArticleRedisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(L09JpaArticleRedisDemoApplication.class, args);
	}

}
