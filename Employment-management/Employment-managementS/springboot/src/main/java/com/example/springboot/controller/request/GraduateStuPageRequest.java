package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class GraduateStuPageRequest extends BaseRequest{
    private String name;
    private String number;

}
