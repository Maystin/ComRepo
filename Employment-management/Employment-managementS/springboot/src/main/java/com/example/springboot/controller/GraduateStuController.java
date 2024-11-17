package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.GraduateStuPageRequest;
import com.example.springboot.entity.GraduateStu;
import com.example.springboot.service.IGraduateStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin    //跨域错误解决方法
@RestController
@RequestMapping("/graduateStu")
public class GraduateStuController {

    @Autowired
    IGraduateStuService graduateStuService;

    @PostMapping("/save")                   //用于新增用户（增）
    public Result save(@RequestBody GraduateStu obj){
        graduateStuService.save(obj);
        return Result.success();
    }
    @PutMapping("/update")                 //修改用户（改）
    public Result update(@RequestBody GraduateStu obj){
        graduateStuService.update(obj);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")        //删除用户（删）
    public Result delete(@PathVariable Integer id) {
        graduateStuService.deleteById(id);
        return Result.success();
    }


    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        GraduateStu obj =graduateStuService.getById(id);
        return Result.success(obj);
    }


    @GetMapping("/list")
    public Result list() {
        List<GraduateStu> list=graduateStuService.list();
        return Result.success(list);
    }

    @GetMapping("/page")
    public Result page(GraduateStuPageRequest graduateStuPageRequest) {
        return Result.success(graduateStuService.page(graduateStuPageRequest));
    }

}
