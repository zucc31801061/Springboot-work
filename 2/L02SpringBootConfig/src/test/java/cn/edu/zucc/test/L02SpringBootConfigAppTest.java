package cn.edu.zucc.test;

import cn.edu.zucc.ConfigurationPropertiesBean;
import cn.edu.zucc.ConfigurationPropertiesBeanValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zucc
 * @version 1.0
 * @date 2021/03/13 21:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class L02SpringBootConfigAppTest {
    @Autowired
    private ConfigurationPropertiesBean configBean;

    @Autowired
    private ConfigurationPropertiesBeanValue configBeanValue;

    @Test
    public void contextLoads() {
        System.out.println(configBean);
        System.out.println(configBeanValue);
    }
}
