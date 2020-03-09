package com.dxb.tdd.ppt.controller;

import com.dxb.tdd.ppt.model.User;
import com.dxb.tdd.ppt.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * User: dxb
 * Date: 2020/2/19
 * Description: When I wrote this, only God and I understood what I was doing. Now, God only knows
 */
public class UserController {

    private UserService userService;

    public UserService getUserService() {
        return this.userService;
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public String login(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = userService.login(userName, password);
        if (null == user) {
            return "No such user";
        }
        return "login success";
    }
}
