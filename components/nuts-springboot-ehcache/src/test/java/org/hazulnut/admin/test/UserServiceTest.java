package org.hazulnut.admin.test;

import org.hazulnut.AbstractSpringBootTest;
import org.hazulnut.admin.entity.UserPO;
import org.hazulnut.admin.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

/**
 * user service test.
 *
 * <p>user service test
 *
 * @author <a href="https://blog.csdn.net/yidichaxiang" target="_blank">Sleeber</a>
 * @since 1.3.0
 *
 * <p><b>Note:</b>
 * <p>2020/11/16 17:05: created.<br>
 */
@SpringBootTest
public class UserServiceTest extends AbstractSpringBootTest {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Test
    public void testQueryUser() {
        UserService userService = webApplicationContext.getBean(UserService.class);
        Assert.isInstanceOf(UserService.class, userService, "UserService对象不能为空");
        List<UserPO> userPOList = userService.getList();
        userPOList.forEach(userPO -> {
            logger.info(userPO.toString());
        });
        Assert.isTrue(userPOList.size() > 0, "数据库记录查询异常");
    }
}
