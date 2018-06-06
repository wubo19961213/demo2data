package com.wubo.demo2data.Controller;

import com.wubo.demo2data.Entity.User;
import com.wubo.demo2data.cluster.Service.UserServiceCluster;
import com.wubo.demo2data.master.Service.UserServiceMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/UserControllerCluster")
public class UserControllerCluster {

    @Autowired
    private UserServiceCluster userServiceCluster;

    @RequestMapping(value = "/insert")
    public int insertController(User user)
    {
        return userServiceCluster.insertUser(user);

    }
    @RequestMapping(value = "/selectAll")
    public List<User> insertController()
    {
        return userServiceCluster.selectAllUser();

    }
    @RequestMapping("/selectUser/{id}")
    public User selectUser(@PathVariable("id") int id)
    {
        return  userServiceCluster.selectUser(id);
    }

    @RequestMapping("/updateUser")
    public int updateUser(User user)
    {
        return userServiceCluster.updateUser(user);
    }

    @RequestMapping("/deleteUser")
    public int deleteUser(int id)
    {
        return userServiceCluster.deleteUser(id);
    }
    @Value("${name}")
    String name ;
    @RequestMapping("/name")
    public String name()
    {
        return name;
    }

}
