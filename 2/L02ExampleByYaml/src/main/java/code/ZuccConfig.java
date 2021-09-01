package code;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Data
@Component
@EnableConfigurationProperties(ZuccConfig.class)
@ConfigurationProperties(prefix = "zucc")
public class ZuccConfig {
    private int year;

    @Bean
    public OurSchool ourSchool(){
        if(year < 2020){
            return new OurSchool("浙江大学城市学院");
        } else {
            return new OurSchool("浙大城市学院");
        }
    }
}
