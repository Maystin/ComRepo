package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data   //替代模板代码，之后帮你生成好你的模板代码
public class GraduateStu {
    private Integer id;
    private String name;
    private String gyear;
    private String sex;
    private String university;
    private String phone;
    private String department;
    private String major;
    private String number;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createtime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date updatetime;

}
