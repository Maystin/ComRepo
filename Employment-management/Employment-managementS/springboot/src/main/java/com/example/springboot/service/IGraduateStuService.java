package com.example.springboot.service;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.entity.GraduateStu;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IGraduateStuService {

    List<GraduateStu> list();

    PageInfo<GraduateStu> page(BaseRequest baseRequest);

    void save(GraduateStu obj);

    GraduateStu getById(Integer id);

    void update(GraduateStu obj);

    void deleteById(Integer id);

}
