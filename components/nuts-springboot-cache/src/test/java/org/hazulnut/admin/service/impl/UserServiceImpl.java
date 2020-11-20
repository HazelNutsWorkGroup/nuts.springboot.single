package org.hazulnut.admin.service.impl;

import org.hazulnut.admin.entity.UserPO;
import org.hazulnut.admin.mapper.UserMapper;
import org.hazulnut.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User Service implement.
 *
 * <p>User Service implement
 *
 * @author <a href="https://blog.csdn.net/yidichaxiang" target="_blank">Sleeber</a>
 * @since 1.3.0
 *
 * <p><b>Note:</b>
 * <p>2020/11/16 16:54: created.<br>
 */

@Service("userService")
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(cacheNames = {"user"})
    public List<UserPO> getList() {
        System.out.println("查询Users");
        return userMapper.selectAllUser();
    }
}
