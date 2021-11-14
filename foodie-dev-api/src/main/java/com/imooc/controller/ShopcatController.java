package com.imooc.controller;

import com.imooc.pojo.bo.ShopcartBO;
import com.imooc.utils.WebResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("shopcart")
@RestController
public class ShopcatController {

    @PostMapping("/add")
    public WebResponse add(
            @RequestParam String userId,
            @RequestParam ShopcartBO shopcartBO,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {

        if (StringUtils.isBlank(userId)) {
            return WebResponse.errorMsg("");
        }

        System.out.println(shopcartBO);

        return WebResponse.ok();
    }
}
