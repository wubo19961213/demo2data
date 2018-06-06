package com.wubo.demo2data.cluster.Service.Impl;

import com.wubo.demo2data.cluster.Dao.userMapper_C;
import com.wubo.demo2data.Entity.User;
import com.wubo.demo2data.cluster.Service.UserServiceCluster;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceClusterImpl implements UserServiceCluster {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserServiceClusterImpl.class);
    @Autowired
    private userMapper_C userMapperC;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    @Transactional
    public int insertUser(User user) {

        String key = "user_" + user.getId();
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set(key, user);
        return userMapperC.insertUser(user);

    }

    @Override
    public List<User> selectAllUser() {
        List<User> list = userMapperC.selectAllUser();
        return list;
    }

    @Override
    public User selectUser(int id) {
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        String key = "user_" + id;
        //如果缓存存在
        Boolean hasKey = redisTemplate.hasKey(key);
        User user = new User();
        if (hasKey) {
            //从缓存中获取值
            user = operations.get(key);
            LOGGER.info("从缓存中获取用户" + user.toString());
            return user;
        }
        //从DB获取值
        user = userMapperC.selectUser(id);
        operations.set(key, user);
        LOGGER.info("把数据插入缓存");
        return user;
    }

    @Override
    public int updateUser(User user) {
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        String key = "user_" + user.getId();
        //ValueOperations<String, User> operations = redisTemplate.opsForValue();
        boolean hashKey = redisTemplate.hasKey(key);
        if (hashKey) {
            //从缓存删除旧数据
            redisTemplate.delete(key);
            LOGGER.info("从缓存删除旧数据");
            //把新数据插入缓存
            operations.set(key, user);
            LOGGER.info("把新数据插入缓存");
            return userMapperC.updateUser(user);
        }
        operations.set(key, user);
        LOGGER.info("把数据插入缓存");
        return userMapperC.updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        String key = "user_" + id;
        //ValueOperations<String, User> operations = redisTemplate.opsForValue();
        boolean hashKey = redisTemplate.hasKey(key);
        if (hashKey) {
            //删除缓存数据
            redisTemplate.delete(key);
            LOGGER.info("删除缓存数据");
            return userMapperC.deleteUser(id);
        }
        return userMapperC.deleteUser(id);
    }
}
