<h1 align="center"><a href="README.md">Nuts - SpringBoot Component Kits</a></h1>  

**<p align="right">「nuts-springboot-logback」日志工具组件</p>**
「nuts-springboot-logback」是日志组件模块项目，可选使用。  
# <a id="nav">目录</a>

1. **[介绍](#info)**  
    1.1. [开发环境](#dev)  
    1.2. [术语与缩写解释](#word)
2. **[安装配置](#config)**  
    2.1. [配置步骤](#step)  
    2.2. [注意事项](#focus) 
3. **[参考链接](#ref)** 

# <a id="info">1. 介绍</a>
*简要介绍*    

## <a id="dev">1.1. 开发环境</a>  
- **JDK 1.8.0_211+**
- **Gradle 5.2+**
- **IntelliJ IDEA ULTIMATE 2019.1+**

<p align="right"><a href="#">返回顶部</a></p>  

## <a id="word">1.2. 术语与缩写解释</a>  
| 术语、缩写 | 解释 |
| --- | --- |
| *「术语、缩写」* | *对「术语、缩写」的解释说明。* |
| | |
> **提示：**列出本文档中的相关术语、缩写的解释。

<p align="right"><a href="#">返回顶部</a></p>  

# <a id="config">2. 安装配置</a>
## <a id="step">2.1. 配置步骤</a>  

+ **步骤一**  
    引入logback相关依赖包
```html
    <html>
        dependencies {
            implementation 'ch.qos.logback:logback-classic'
            implementation 'org.apache.logging.log4j:log4j-to-slf4j'
        }
    </html>
```  
> **提示：** 需要注意的地方  

+ **步骤二** 
    增加logback-spring.xml文件
```html
    <html>
        <?xml version="1.0" encoding="UTF-8"?>
        <configuration>
            <include resource="org/springframework/boot/logging/logback/defaults.xml"/>
            <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
                <filter class="ch.qos.logback.classic.filter.LevelFilter">
                    <level>INFO</level>
                </filter>
                <encoder>
                    <pattern>%date [%thread] %-5level [%logger{50}] %file:%line - %msg%n</pattern>
                    <charset>UTF-8</charset>
                </encoder>
            </appender>
        
            <appender name="FILE_INFO" class="ch.qos.logback.core.rolling.RollingFileAppender">
                <!--如果只是想要 Info 级别的日志，只是过滤 info 还是会输出 Error 日志，因为 Error 的级别高， 所以我们使用下面的策略，可以避免输出 Error 的日志-->
                <filter class="ch.qos.logback.classic.filter.LevelFilter">
                    <!--过滤 Error-->
                    <level>ERROR</level>
                    <!--匹配到就禁止-->
                    <onMatch>DENY</onMatch>
                    <!--没有匹配到就允许-->
                    <onMismatch>ACCEPT</onMismatch>
                </filter>
                <!--日志名称，如果没有File 属性，那么只会使用FileNamePattern的文件路径规则如果同时有<File>和<FileNamePattern>，那么当天日志是<File>，明天会自动把今天的日志改名为今天的日期。即，<File> 的日志都是当天的。-->
                <!--<File>logs/info.spring-boot-demo-logback.log</File>-->
                <!--滚动策略，按照时间滚动 TimeBasedRollingPolicy-->
                <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                    <!--文件路径,定义了日志的切分方式——把每一天的日志归档到一个文件中,以防止日志填满整个磁盘空间-->
                    <FileNamePattern>logs/info.created_on_%d{yyyy-MM-dd}.part_%i.log</FileNamePattern>
                    <!--只保留最近90天的日志-->
                    <maxHistory>90</maxHistory>
                    <!--用来指定日志文件的上限大小，那么到了这个值，就会删除旧的日志-->
                    <!--<totalSizeCap>1GB</totalSizeCap>-->
                    <timeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                        <!-- maxFileSize:这是活动文件的大小，默认值是10MB,本篇设置为1KB，只是为了演示 -->
                        <maxFileSize>2MB</maxFileSize>
                    </timeBasedFileNamingAndTriggeringPolicy>
                </rollingPolicy>
                <!--<triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">-->
                <!--<maxFileSize>1KB</maxFileSize>-->
                <!--</triggeringPolicy>-->
                <encoder>
                    <pattern>%date [%thread] %-5level [%logger{50}] %file:%line - %msg%n</pattern>
                    <charset>UTF-8</charset> <!-- 此处设置字符集 -->
                </encoder>
            </appender>
            <appender name="FILE_WARN" class="ch.qos.logback.core.rolling.RollingFileAppender">
                <!--如果只是想要 Warn 级别的日志，只是过滤 info 还是会输出 Error 日志，因为 Error 的级别高， 所以我们使用下面的策略，可以避免输出 Error 的日志-->
                <filter class="ch.qos.logback.classic.filter.LevelFilter">
                    <!--过滤 Error-->
                    <level>WARN</level>
                    <!--匹配到就禁止-->
                    <onMatch>DENY</onMatch>
                    <!--没有匹配到就允许-->
                    <onMismatch>ACCEPT</onMismatch>
                </filter>
                <!--日志名称，如果没有File 属性，那么只会使用FileNamePattern的文件路径规则如果同时有<File>和<FileNamePattern>，那么当天日志是<File>，明天会自动把今天的日志改名为今天的日期。即，<File> 的日志都是当天的。-->
                <!--<File>logs/info.spring-boot-demo-logback.log</File>-->
                <!--滚动策略，按照时间滚动 TimeBasedRollingPolicy-->
                <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                    <!--文件路径,定义了日志的切分方式——把每一天的日志归档到一个文件中,以防止日志填满整个磁盘空间-->
                    <FileNamePattern>logs/warn.created_on_%d{yyyy-MM-dd}.part_%i.log</FileNamePattern>
                    <!--只保留最近90天的日志-->
                    <maxHistory>90</maxHistory>
                    <!--用来指定日志文件的上限大小，那么到了这个值，就会删除旧的日志-->
                    <!--<totalSizeCap>1GB</totalSizeCap>-->
                    <timeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                        <!-- maxFileSize:这是活动文件的大小，默认值是10MB,本篇设置为1KB，只是为了演示 -->
                        <maxFileSize>2MB</maxFileSize>
                    </timeBasedFileNamingAndTriggeringPolicy>
                </rollingPolicy>
                <!--<triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">-->
                <!--<maxFileSize>1KB</maxFileSize>-->
                <!--</triggeringPolicy>-->
                <encoder>
                    <pattern>%date [%thread] %-5level [%logger{50}] %file:%line - %msg%n</pattern>
                    <charset>UTF-8</charset> <!-- 此处设置字符集 -->
                </encoder>
            </appender>
            <appender name="FILE_ERROR" class="ch.qos.logback.core.rolling.RollingFileAppender">
                <!--如果只是想要 Error 级别的日志，那么需要过滤一下，默认是 info 级别的，ThresholdFilter-->
                <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
                    <level>Error</level>
                </filter>
                <!--日志名称，如果没有File 属性，那么只会使用FileNamePattern的文件路径规则如果同时有<File>和<FileNamePattern>，那么当天日志是<File>，明天会自动把今天的日志改名为今天的日期。即，<File> 的日志都是当天的。-->
                <!--<File>logs/error.spring-boot-demo-logback.log</File>-->
                <!--滚动策略，按照时间滚动 TimeBasedRollingPolicy-->
                <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                    <!--文件路径,定义了日志的切分方式——把每一天的日志归档到一个文件中,以防止日志填满整个磁盘空间-->
                    <FileNamePattern>logs/error.created_on_%d{yyyy-MM-dd}.part_%i.log</FileNamePattern>
                    <!--只保留最近90天的日志-->
                    <maxHistory>90</maxHistory>
                    <timeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                        <!-- maxFileSize:这是活动文件的大小，默认值是10MB,本篇设置为1KB，只是为了演示 -->
                        <maxFileSize>2MB</maxFileSize>
                    </timeBasedFileNamingAndTriggeringPolicy>
                </rollingPolicy>
                <encoder>
                    <pattern>%date [%thread] %-5level [%logger{50}] %file:%line - %msg%n</pattern>
                    <charset>UTF-8</charset> <!-- 此处设置字符集 -->
                </encoder>
            </appender>
        
            <root level="info">
                <appender-ref ref="CONSOLE"/>
                <appender-ref ref="FILE_INFO"/>
                <appender-ref ref="FILE_INFO"/>
                <appender-ref ref="FILE_ERROR"/>
            </root>
        </configuration>
    </html>
```  
> **提示：** 需要注意的地方  


<p align="right"><a href="#">返回顶部</a></p>  

## <a id="focus">2.2. 注意事项</a>
| 框架、组件 | 注意事项 |
| --- | --- |
| *「框架、组件」* | *「框架、组件」的引入/配置的注意事项。* |
| | |

> **提示：**列出项目开发中引入其他框架或技术需要特别关注或配置的事项。

<p align="right"><a href="#">返回顶部</a></p>  

# <a id="ref">3. 参考链接</a>  
| 框架、组件 | 参考链接 | 关键概念/步骤 |
| --- | --- | --- |
| *「框架、组件」* | *「框架、组件」的参考链接* |  *其中的关键概念/步骤* |
| | | |

> **提示：**列出本文档的所有参考文献（可以是非正式出版物，或是开源项目）.  

<p align="right"><a href="#">返回顶部</a></p>  

&copy;Copyright 2020 Sleeber(anch8apparition@163.com) Apache License 2.0, 详情见 LICENSE 文件。
