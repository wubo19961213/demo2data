package com.wubo.demo2data.cluster.Service;

import com.wubo.demo2data.Entity.User;

import java.util.List;

public interface UserServiceCluster {
    int insertUser(User user);
    List<User> selectAllUser();
    User selectUser(int id);
    int updateUser(User user);
    int deleteUser(int id);
}
