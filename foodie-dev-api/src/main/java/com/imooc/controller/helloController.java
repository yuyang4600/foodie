package com.imooc.controller;

import com.imooc.service.StuService;
import com.imooc.utils.WebResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ApiIgnore
@RestController
public class helloController {

    final static Logger log = LoggerFactory.getLogger(helloController.class);

    @Autowired
    private StuService stuService;

    @GetMapping("/hello")
    public Object hello() {
        log.info("info: hello");
        log.debug("debug: hello");
        log.warn("warn : hello");
        log.error("error: hello");
        return WebResponse.ok();
    }

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

    @GetMapping("/setSession")
    public Object setSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userInfo", "new User");
        session.setMaxInactiveInterval(3600);
        session.getAttribute("userInfo");

        return "ok";

    }
}
