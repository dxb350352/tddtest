package com.dxb.tdd.ppt.service;

import com.dxb.tdd.ppt.model.User;

import java.util.List;

/**
 * User: dxb
 * Date: 2020/2/19
 * Description: When I wrote this, only God and I understood what I was doing. Now, God only knows
 */
public class UserService {

    public User login(String userName, String password) {
        System.out.println(String.format("userName:%s,password:%s", userName, password));
        return null;
    }

    public User insert(int id, String userName, String password) {
        return null;
    }

    public void batch(List<User> users){
    }

    public User insert(User user){
        return null;
    }

}
