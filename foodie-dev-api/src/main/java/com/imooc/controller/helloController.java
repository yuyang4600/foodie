package com.imooc.controller;

import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @Autowired
    private StuService stuService;

    @GetMapping("/getStuInfo")
    public Object getStuInfo(int id) {
        return stuService.getStu(id);
    }

    @PostMapping("/saveStuInfo")
    public Object saveStuInfo() {
        stuService.saveStu();
        return "OK";
    }

    @PutMapping("/updateStuInfo")
    public Object updateStuInfo(int id) {
        stuService.updateStu(id);
        return "OK";
    }

    @DeleteMapping("/deleteStuInfo")
    public Object deleteStuInfo(int id) {
        stuService.deleteStu(id);
        return "OK";
    }
}
