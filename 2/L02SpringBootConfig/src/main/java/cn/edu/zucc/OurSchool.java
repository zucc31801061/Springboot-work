package cn.edu.zucc;

import lombok.Data;

/**
 * @author zucc
 * @version 1.0
 * @date 2021/03/14 10:45
 */
@Data
public class OurSchool {
    private String name;
    public OurSchool(String name) {
        this.name = name;
    }
}
