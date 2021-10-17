package com.imooc.controller;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBo;
import com.imooc.service.UserService;
import com.imooc.utils.CookieUtils;
import com.imooc.utils.JsonUtils;
import com.imooc.utils.MD5Utils;
import com.imooc.utils.WebResponse;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "注册登陆", tags = {"用于注册登陆的接口"})
@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @GetMapping("/usernameIsExist")
    public WebResponse userNameIsExist(@RequestParam String username) {
        if (StringUtils.isBlank(username)) {
            return WebResponse.errorMsg("username is null");
        }

        if (userService.queryUserNameIsExist(username)) {
            return WebResponse.errorMsg("username already exist");
        }

        return WebResponse.ok();
    }

    @PostMapping("/regist")
    public WebResponse regist(@RequestBody UserBo userBo) {
        String userName = userBo.getUsername();
        String password = userBo.getPassword();
        String confirmPassword = userBo.getConfirmPassword();

        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password) || StringUtils.isBlank(confirmPassword)) {
            return WebResponse.errorMsg("用户名或密码不能为空");
        }

        if (password.length() < 6) {
            return WebResponse.errorMsg("密码不能小于6位");
        }
        if (!password.equals(confirmPassword)) {
            return WebResponse.errorMsg("两次密码输入不一致");
        }

        userService.createUser(userBo);

        return WebResponse.ok();
    }

    @PostMapping("/login")
    public WebResponse queryUserForLogin(@RequestBody UserBo userBo, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userName = userBo.getUsername();
        String password = userBo.getPassword();

        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            return WebResponse.errorMsg("用户名或密码不能为空");
        }

        Users users = userService.queryUserForLogin(userName, MD5Utils.getMD5Str(password));
        if (users == null) {
            return WebResponse.errorMsg("用户名或密码不正确");

        }
        users = setNullProperty(users);

        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(users), true);

        return WebResponse.ok(users);
    }

    private Users setNullProperty(Users user) {
        user.setPassword(null);
        user.setEmail(null);
        user.setBirthday(null);

        return user;
    }

    @PostMapping("/logout")
    public WebResponse logout(@RequestParam String userId, HttpServletRequest request, HttpServletResponse response) {
        CookieUtils.deleteCookie(request, response, "user");

        return WebResponse.ok();
    }
}
