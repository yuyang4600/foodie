package com.imooc.controller;

import com.imooc.pojo.bo.ShopcartBO;
import com.imooc.utils.WebResponse;
import io.swagger.annotations.ApiOperation;
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
            @RequestBody ShopcartBO shopcartBO,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {

        if (StringUtils.isBlank(userId)) {
            return WebResponse.errorMsg("");
        }

        System.out.println(shopcartBO);

        return WebResponse.ok();
    }

    @ApiOperation(value = "从购物车中删除商品", notes = "从购物车中删除商品", httpMethod = "POST")
    @PostMapping("/del")
    public WebResponse del(
            @RequestParam String userId,
            @RequestParam String itemSpecId,
            HttpServletRequest request,
            HttpServletResponse response
    ) {

        if (StringUtils.isBlank(userId) || StringUtils.isBlank(itemSpecId)) {
            return WebResponse.errorMsg("参数不能为空");
        }

        // TODO 用户在页面删除购物车中的商品数据，如果此时用户已经登录，则需要同步删除后端购物车中的商品

        return WebResponse.ok();
    }
}
