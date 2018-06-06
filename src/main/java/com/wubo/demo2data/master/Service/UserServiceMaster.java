package com.wubo.demo2data.master.Service;

import com.wubo.demo2data.Entity.User;

import java.util.List;

public interface UserServiceMaster {
    int insertUser(User user);
    List<User> selectAllUser();
    int updateUser(User user);
    int delete(int id );
    List<User> selectUserName(User user);
}
