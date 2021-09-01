package cn.edu.zucc;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zucc
 * @version 1.0
 * @date 2021/03/13 21:16
 */
@Data
@Component
@ConfigurationProperties(prefix = "demo")
public class ConfigurationPropertiesBean {
    private String sValue;
    private int nValue;

    @Override
    public String toString() {
        return "ConfigurationPropertiesBean{" +
                "sValue='" + sValue + '\'' +
                ", nValue=" + nValue +
                '}';
    }
}
