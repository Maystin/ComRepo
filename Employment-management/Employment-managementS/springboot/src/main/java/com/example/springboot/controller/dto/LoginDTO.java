package com.example.springboot.controller.dto;

import lombok.Data;

@Data
public class LoginDTO {                  //专门用来封装Dto返回的数据
    private Integer id;
    private String username;
    private String phone;
    private String email;
    private String token;

//    public void setToken(String token) {
//    }
}
