package com.example.springboot.mapper;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<Category> list();

    List<Category> listByCondition(BaseRequest baseRequest);  //传入一个基类，根据实际调用的时候再去传实际的类

    void save(Category obj);

    Category getById(Integer id);

    void updateById(Category user);

    void deleteById(Integer id);


    void selectByPid(Integer pid);
}
