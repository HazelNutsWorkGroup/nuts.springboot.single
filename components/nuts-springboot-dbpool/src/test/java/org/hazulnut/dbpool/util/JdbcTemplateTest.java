package org.hazulnut.dbpool.util;

import org.hazulnut.dbpool.AbstractSpringBootTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

/**
 * JdbcTemplate test.
 *
 * <p>JdbcTemplate business test
 *
 * @author <a href="https://blog.csdn.net/yidichaxiang" target="_blank">Sleeber</a>
 * @since 1.3.0
 *
 * <p><b>Note:</b>
 * <p>2020/7/29 22:28: created.<br>
 */
@SpringBootTest
public class JdbcTemplateTest extends AbstractSpringBootTest {
    private static final Logger logger = LoggerFactory.getLogger(JdbcTemplateTest.class);

    @Test
    public void getAllUser() {
        JdbcTemplate jdbcTemplate = webApplicationContext.getBean(JdbcTemplate.class);
        Assert.isTrue(jdbcTemplate.queryForList("Select 3", Integer.class).get(0).equals(3), "数据库连接异常");
    }
}
