package org.hazulnut.dbpool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


/**
 * database configuration.
 *
 * <p>global database configuration
 *
 * @author <a href="https://blog.csdn.net/yidichaxiang" target="_blank">Sleeber</a>
 * @since 1.3.0
 *
 * <p><b>Note:</b>
 * <p>2020/7/29 21:19: created.<br>
 */
@ConditionalOnClass(name = {"com.mysql.cj.jdbc.Driver"})
@Configuration
public class MysqlDbPoolConfiguration {

    @ConditionalOnClass(name = {"com.zaxxer.hikari.HikariDataSource"})
    @Bean(destroyMethod = "close", name = "mysqlJdbcDataSource")
    @ConfigurationProperties("spring.datasource.hikari")
    public DataSource getHikariCPDatabasePool() {
        return DataSourceBuilder.create().build();
    }

    @ConditionalOnClass(name = {"com.alibaba.druid.pool.DruidDataSource"})
    @Bean(destroyMethod = "close", name = "mysqlJdbcDataSource")
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource getDruidDatabasePool() {
        return DataSourceBuilder.create().type(com.alibaba.druid.pool.DruidDataSource.class).build();
    }

//    @ConditionalOnClass(name = {"org.apache.tomcat.jdbc.pool.DataSource"})
//    @Bean(destroyMethod = "close", name = "mysqlJdbcDataSource")
//    @ConfigurationProperties("spring.datasource.tomcat")
//    public DataSource getTomcatDatabasePool() {
//        return DataSourceBuilder.create().type(org.apache.tomcat.jdbc.pool.DataSource.class).build();
//    }

//    @ConditionalOnClass(name = {"org.apache.commons.dbcp2.BasicDataSource"})
//    @Bean(destroyMethod = "close", name = "mysqlJdbcDataSource")
//    @ConfigurationProperties("spring.datasource.dbcp2")
//    public DataSource getDbcp2DatabasePool() {
//        return DataSourceBuilder.create().type(org.apache.commons.dbcp2.BasicDataSource.class).build();
//    }

//    @ConditionalOnClass(name = {"com.mchange.v2.c3p0.ComboPooledDataSource"})
//    @Bean(destroyMethod = "close", name = "mysqlJdbcDataSource")
//    @ConfigurationProperties("spring.datasource.c3p0")
//    public DataSource getC3p0DatabasePool() {
//        return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
//    }


    @ConditionalOnBean(value = {javax.sql.DataSource.class})
    @Bean(name = "mysqlJdbcTemplate")
    public JdbcTemplate getMysqlJdbcTemplate(@Autowired DataSource mysqlJdbcDataSource) {
        return new JdbcTemplate(mysqlJdbcDataSource);
    }

}
