package com.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class Student {
    @NotEmpty(message = "姓名不为空")
    private String name;

    @NotEmpty(message = "学号不能为空")
    @Length(min = 8,max = 8,message = "请输入8位学号")
    private String id;

    @NotNull(message ="性别不能为空")
    @Pattern(regexp = "^[\\u4e00-\\u9fff]{0}?(?:男|女)", message = "请输入“男/女")
    private String sex;

    @Pattern(regexp = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$",message = "身份证格式不正确")
    @NotEmpty(message ="身份证号不能为空")
    private String cardId;

    @Email(message="邮箱格式错误")
    @NotEmpty(message = "邮箱不能为空")
    private String email;

    public Student(){

    }

    public Student(String name, String id, String sex, String cardId, String email) {
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.cardId = cardId;
        this.email = email;
    }
}
