package com.wubo.demo2data.master.Service.Impl;

import com.wubo.demo2data.Entity.User;
import com.wubo.demo2data.cluster.Dao.userMapper_C;
import com.wubo.demo2data.cluster.Service.UserServiceCluster;
import com.wubo.demo2data.master.Dao.userMapper_M;
import com.wubo.demo2data.master.Service.UserServiceMaster;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceMasterImpl implements UserServiceMaster
{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserServiceMasterImpl.class);
    @Autowired
    private userMapper_M userMapper_M;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public int updateUser(User user) {
        /*String key = "users_" + user.getId();
        boolean hasKey = redisTemplate.hasKey(key);
        ValueOperations<String,User> operations = redisTemplate.opsForValue();
        if(hasKey)
        {
            redisTemplate.delete(key);
            operations.set(key,user);
            return userMapper_M.updateUser(user);
        }
        operations.set(key,user);*/
        return userMapper_M.updateUser(user);
    }

    @Override
    public int delete(int id) {
        String key = "users_" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey)
        {
            redisTemplate.delete(key);
            return userMapper_M.delete(id);
        }
        return userMapper_M.delete(id);
    }

    @Override
    @Transactional
    public int insertUser(User user){
        String key = "users_"+user.getId();
        ValueOperations<String,User> operations = redisTemplate.opsForValue();
        //ValueOperations<String,User> operations = redisTemplate.opsForValue();
        operations.set(key,user);
        return userMapper_M.insertUser(user);

    }

    @Override
    public List<User> selectAllUser() {
        List<User> list = userMapper_M.selectAllUser();
       /* String key;
        ValueOperations<String,User> operations = redisTemplate.opsForValue();
        for (User user1:
                list) {
            key = "users_"+user1.getId();
            operations.set(key,user1);
        }*/
        return list;
    }
    public List<User> selectUserName(User user)
    {
        List<User> listUser = userMapper_M.selectUserName(user);
        /*String key ;
        ValueOperations<String,User> operations = redisTemplate.opsForValue();
        boolean hashkey;
        for (User user1:user
             ) {
            key = "users_"+user1.getId();
            hashkey = redisTemplate.hasKey(key);
            if(!hashkey) {
                operations.set(key, user1);
            }
        }*/
        return listUser;
    }
}
