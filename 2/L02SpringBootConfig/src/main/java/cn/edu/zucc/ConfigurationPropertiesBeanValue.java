package cn.edu.zucc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zucc
 * @version 1.0
 * @date 2021/03/13 21:16
 */
@Data
@Component
public class ConfigurationPropertiesBeanValue {
    @Value("${demo-value.string}")
    private String sValue;
    @Value("${demo-value.int}")
    private int nValue;

    @Override
    public String toString() {
        return "ConfigurationPropertiesBeanValue{" +
                "sValue='" + sValue + '\'' +
                ", nValue=" + nValue +
                '}';
    }
}
