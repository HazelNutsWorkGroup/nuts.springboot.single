package org.hazulnut.dbpool.config;

import org.hazulnut.AbstractSpringBootTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;

@SpringBootTest(classes = {MysqlDbPoolConfiguration.class})
class MysqlDbPoolConfigurationTest extends AbstractSpringBootTest {
    private static final Logger logger = LoggerFactory.getLogger(MysqlDbPoolConfigurationTest.class);

    @Test
    void getMysqlJdbcTemplate() {
        JdbcTemplate jdbcTemplate = webApplicationContext.getBean(JdbcTemplate.class);
        Assert.isInstanceOf(JdbcTemplate.class, jdbcTemplate, "SpringBoot数据库模板jdbcTemplate对象不能为空");
    }

    @Test
    void getMysqlJdbcDataSource() {
        DataSource dataSource = webApplicationContext.getBean(DataSource.class);
        Assert.isInstanceOf(DataSource.class, dataSource,"数据库数据源对象不能为空");
    }
}