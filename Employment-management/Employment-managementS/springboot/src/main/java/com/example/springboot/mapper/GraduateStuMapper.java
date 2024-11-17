package com.example.springboot.mapper;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.entity.GraduateStu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GraduateStuMapper {

    List<GraduateStu> list();

    List<GraduateStu> listByCondition(BaseRequest baseRequest);

    void save(GraduateStu obj);

    GraduateStu getById(Integer id);

    void updateById(GraduateStu obj);

    void deleteById(Integer id);
}
