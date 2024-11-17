package com.example.springboot.service.impl;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.entity.GraduateStu;
import com.example.springboot.mapper.GraduateStuMapper;
import com.example.springboot.service.IGraduateStuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GraduateStuService implements IGraduateStuService {

    @Autowired
    GraduateStuMapper graduateStuMapper;

    @Override
    public List<GraduateStu> list() {

        return graduateStuMapper.list();
    }

    @Override
    public PageInfo<GraduateStu> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(),baseRequest.getPageSize());
        List<GraduateStu> graduateStus = graduateStuMapper.listByCondition(baseRequest);
        return new PageInfo<>(graduateStus);
    }

    @Override
    public void save(GraduateStu obj) {

    }


    @Override
    public GraduateStu getById(Integer id){

        return graduateStuMapper.getById(id);
    }

    @Override
    public void update(GraduateStu obj){
        obj.setUpdatetime(new Date());
        graduateStuMapper.updateById(obj);
    }

    @Override
    public void deleteById(Integer id) {
        graduateStuMapper.deleteById(id);
    }
}
