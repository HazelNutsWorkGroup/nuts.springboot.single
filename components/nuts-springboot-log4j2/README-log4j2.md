<h1 align="center"><a href="README.md">Nuts - SpringBoot Component Kits</a></h1>  

**<p align="right">「nuts-springboot-log4j2」日志工具组件</p>**
「nuts-springboot-log4j2」是日志组件模块项目，可选使用。  
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
    引入log4j2相关依赖包
```html
    <html>
        dependencies {
            implementation 'org.springframework.boot:spring-boot-starter-log4j2'
        }
    </html>
```  
> **提示：** 需要注意的地方  

+ **步骤二** 
    增加log4j2-spring.xml文件
```html
    <html>
        <?xml version="1.0" encoding="UTF-8"?>
        <!--Configuration后面的status，这个用于设置log4j2自身内部的信息输出，可以不设置，当设置成trace时，你会看到log4j2内部各种详细输出-->
        <!--monitorInterval：Log4j能够自动检测修改配置 文件和重新配置本身，设置间隔秒数-->
        <configuration monitorInterval="5">
            <!--日志级别以及优先级排序: OFF > FATAL > ERROR > WARN > INFO > DEBUG > TRACE > ALL -->
        
            <!--变量配置-->
            <Properties>
                <!-- 格式化输出：%date表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度 %msg：日志消息，%n是换行符-->
                <!-- %logger{36} 表示 Logger 名字最长36个字符 -->
                <property name="LOG_PATTERN" value="%date{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"/>
                <!-- 定义日志存储的路径 -->
                <property name="FILE_PATH" value="logs"/>
                <property name="FILE_NAME" value="clover"/>
            </Properties>
        
            <appenders>
                <console name="Console" target="SYSTEM_OUT">
                    <!--输出日志的格式-->
                    <PatternLayout pattern="${LOG_PATTERN}"/>
                    <!--控制台只输出level及其以上级别的信息（onMatch），其他的直接拒绝（onMismatch）-->
                    <ThresholdFilter level="info" onMatch="ACCEPT" onMismatch="DENY"/>
                </console>
        
                <!--文件会打印出所有信息，这个log每次运行程序会自动清空，由append属性决定，适合临时测试用-->
                <File name="DebugInfo" fileName="${FILE_PATH}/debug.log" append="false">
                    <PatternLayout pattern="${LOG_PATTERN}"/>
                </File>
        
                <!-- 这个会打印出所有的info及以下级别的信息，每次大小超过size，则这size大小的日志会自动存入按年份-月份建立的文件夹下面并进行压缩，作为存档-->
                <RollingFile name="RollingFileInfo" fileName="${FILE_PATH}/info.log"
                             filePattern="${FILE_PATH}/${FILE_NAME}-INFO-%d{yyyy-MM-dd}_%i.log.gz">
                    <!--控制台只输出level及以上级别的信息（onMatch），其他的直接拒绝（onMismatch）-->
                    <ThresholdFilter level="info" onMatch="ACCEPT" onMismatch="DENY"/>
                    <PatternLayout pattern="${LOG_PATTERN}"/>
                    <Policies>
                        <!--interval属性用来指定多久滚动一次，默认是1 hour-->
                        <TimeBasedTriggeringPolicy interval="1"/>
                        <SizeBasedTriggeringPolicy size="10MB"/>
                    </Policies>
                    <!-- DefaultRolloverStrategy属性如不设置，则默认为最多同一文件夹下7个文件开始覆盖-->
                    <DefaultRolloverStrategy max="15"/>
                </RollingFile>
        
                <!-- 这个会打印出所有的warn及以下级别的信息，每次大小超过size，则这size大小的日志会自动存入按年份-月份建立的文件夹下面并进行压缩，作为存档-->
                <RollingFile name="RollingFileWarn" fileName="${FILE_PATH}/warn.log"
                             filePattern="${FILE_PATH}/${FILE_NAME}-WARN-%d{yyyy-MM-dd}_%i.log.gz">
                    <!--控制台只输出level及以上级别的信息（onMatch），其他的直接拒绝（onMismatch）-->
                    <ThresholdFilter level="warn" onMatch="ACCEPT" onMismatch="DENY"/>
                    <PatternLayout pattern="${LOG_PATTERN}"/>
                    <Policies>
                        <!--interval属性用来指定多久滚动一次，默认是1 hour-->
                        <TimeBasedTriggeringPolicy interval="1"/>
                        <SizeBasedTriggeringPolicy size="10MB"/>
                    </Policies>
                    <!-- DefaultRolloverStrategy属性如不设置，则默认为最多同一文件夹下7个文件开始覆盖-->
                    <DefaultRolloverStrategy max="15"/>
                </RollingFile>
        
                <!-- 这个会打印出所有的error及以下级别的信息，每次大小超过size，则这size大小的日志会自动存入按年份-月份建立的文件夹下面并进行压缩，作为存档-->
                <RollingFile name="RollingFileError" fileName="${FILE_PATH}/error.log"
                             filePattern="${FILE_PATH}/${FILE_NAME}-ERROR-%d{yyyy-MM-dd}_%i.log.gz">
                    <!--控制台只输出level及以上级别的信息（onMatch），其他的直接拒绝（onMismatch）-->
                    <ThresholdFilter level="error" onMatch="ACCEPT" onMismatch="DENY"/>
                    <PatternLayout pattern="${LOG_PATTERN}"/>
                    <Policies>
                        <!--interval属性用来指定多久滚动一次，默认是1 hour-->
                        <TimeBasedTriggeringPolicy interval="1"/>
                        <SizeBasedTriggeringPolicy size="10MB"/>
                    </Policies>
                    <!-- DefaultRolloverStrategy属性如不设置，则默认为最多同一文件夹下7个文件开始覆盖-->
                    <DefaultRolloverStrategy max="15"/>
                </RollingFile>
        
            </appenders>
        
            <!--Logger节点用来单独指定日志的形式，比如要为指定包下的class指定不同的日志级别等。-->
            <!--然后定义loggers，只有定义了logger并引入的appender，appender才会生效-->
            <loggers>
                <!--过滤掉spring和mybatis的一些无用的DEBUG信息-->
                <logger name="org.mybatis" level="info" additivity="false">
                    <AppenderRef ref="Console"/>
                </logger>
                <!--监控系统信息-->
                <!--若是additivity设为false，则 子Logger 只会在自己的appender里输出，而不会在 父Logger 的appender里输出。-->
                <Logger name="org.springframework" level="info" additivity="false">
                    <AppenderRef ref="Console"/>
                </Logger>
        
                <root level="info">
                    <appender-ref ref="Console"/>
                    <appender-ref ref="DebugInfo"/>
                    <appender-ref ref="RollingFileInfo"/>
                    <appender-ref ref="RollingFileWarn"/>
                    <appender-ref ref="RollingFileError"/>
                </root>
            </loggers>
        
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
