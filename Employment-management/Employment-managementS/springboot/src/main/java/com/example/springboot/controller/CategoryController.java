package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.CategoryPageRequest;
import com.example.springboot.entity.Category;
import com.example.springboot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin    //跨域错误解决方法
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;


    @PostMapping("/save")                   //用于新增用户（增）
    public Result save(@RequestBody Category obj){
        categoryService.save(obj);
        return Result.success();
    }

    @PutMapping("/update")                 //修改用户（改）
    public Result update(@RequestBody Category obj){
        categoryService.update(obj);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")        //删除用户（删）
    public Result delete(@PathVariable Integer id) {
        categoryService.deleteById(id);
        return Result.success();
    }


    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Category obj =categoryService.getById(id);
        return Result.success(obj);
    }


    @GetMapping("/list")
    public Result list() {
        List<Category> list = categoryService.list();
        return Result.success(list);
    }

    @GetMapping("/page")
    public Result page(CategoryPageRequest pageRequest) {


        return Result.success(categoryService.page(pageRequest));
    }

}
