package com.wubo.demo2data.master.Dao;

import com.wubo.demo2data.Entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface userMapper_M {
    //@Insert("Insert into users(name,sex) values(#{name},#{sex})")
    int insertUser(User user);
    //@Select("select * from users")
    List<User> selectAllUser();
    //@Update("update users set name=#{name},sex=#{sex} where id=#{id}")
    int updateUser(User user);
    //@Delete("delete from users where id=#{id}")
    int delete(int id );
    List<User> selectUserName(User user);
    /*List<User> selectUserNameAndId(Map map);*/
}
