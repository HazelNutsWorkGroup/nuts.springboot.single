package org.hazulnut.admin.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hazulnut.AbstractSpringBootTest;
import org.hazulnut.admin.entity.UserPO;
import org.hazulnut.admin.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

/**
 * User单元测试.
 *
 * <p>User使用Mybatis的单元测试样例
 *
 * @author <a href="https://blog.csdn.net/yidichaxiang" target="_blank">Sleeber</a>
 * @since 1.3.0
 *
 * <p><b>Note:</b>
 * <p>2020/8/4 21:50: created.<br>
 */
@SpringBootTest
public class UserRepositoryTest extends AbstractSpringBootTest {
    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Test
    public void testQueryUser() {
        UserMapper userMapper = webApplicationContext.getBean(UserMapper.class);
        Assert.isInstanceOf(UserMapper.class, userMapper, "UserMapper对象不能为空");
        List<UserPO> userPOList = userMapper.selectAllUser();
        userPOList.forEach(userPO -> {
            logger.info(userPO.toString());
        });
        Assert.isTrue(userPOList.size() > 0, "数据库记录查询异常");
    }

    @Test
    public void testQueryUserPage() {
        UserMapper userMapper = webApplicationContext.getBean(UserMapper.class);
        Assert.isInstanceOf(UserMapper.class, userMapper, "UserMapper对象不能为空");
        PageHelper.startPage(1, 1);
        List<UserPO> userPOList = userMapper.selectAllUser();
        PageInfo<UserPO> pageInfo = new PageInfo<>(userPOList, 1);
        userPOList.forEach(userPO -> {
            logger.info(userPO.toString());
        });
        Assert.isTrue(userPOList.size() == 1, "数据库记录查询异常");

    }

}
