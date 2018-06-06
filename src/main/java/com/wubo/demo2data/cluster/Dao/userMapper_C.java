package com.wubo.demo2data.cluster.Dao;

import com.wubo.demo2data.Entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface userMapper_C {
    int insertUser(User user);
    List<User> selectAllUser();
    User selectUser(int id);
    int updateUser(User user);
    int deleteUser(int id);
}
