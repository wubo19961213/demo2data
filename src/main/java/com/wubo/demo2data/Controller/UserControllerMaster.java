package com.wubo.demo2data.Controller;

import com.wubo.demo2data.Entity.User;
import com.wubo.demo2data.master.Service.UserServiceMaster;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/UserControllerMaster")
public class UserControllerMaster {
    @Autowired
    private UserServiceMaster userServiceMaster;
    @RequestMapping(value = "/userMaster",method = RequestMethod.GET)
    public List<User> selectAll()
    {
        return userServiceMaster.selectAllUser();
    }

    @RequestMapping(value = "/userMaster/{id}",method = RequestMethod.DELETE)
    public int delete(@PathVariable("id") int id)
    {
        return  userServiceMaster.delete(id);
    }

    @RequestMapping(value = "/userMaster",method = RequestMethod.PUT)
    public int update(User user)
    {
        return userServiceMaster.updateUser(user);
    }
    @RequestMapping(value = "/userMaster",method = RequestMethod.POST)
    public int insert( User user)
    {
        return userServiceMaster.insertUser(user);
    }

    @RequestMapping(value = "/selectUserName",method = RequestMethod.GET)
    public List<User> selectUserName(User user)
    {
        return userServiceMaster.selectUserName(user);
    }
}
