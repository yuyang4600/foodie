package com.imooc.service;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBo;

public interface UserService {

    boolean queryUserNameIsExist(String userName);

    Users createUser(UserBo userBo);

    Users queryUserForLogin(String username, String passWord);
}
