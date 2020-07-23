<h1 align="center"><a href="README.md">Nuts - SpringBoot Component Kits</a></h1>  

**<p align="right">「Nuts-SpringBoot-Single」整体型项目框架技术</p>**
`SpringBoot Component Kits`是一套深度使用`SpringBoot`及周边生态的项目快速搭建工具集。
「Nuts-SpringBoot-Single」主要是针对整体型项目进行技术选型及设计的，多进程或微服务类型的项目请慎重参考。

# <a id="nav">目录</a>

1. **[介绍](#info)**  
    1.1. [开发环境](#dev)  
    1.2. [术语与缩写解释](#word)
2. **[软件结构](#soft)**  
    2.1. [项目目录结构](#dir)  
    2.2. [Module列表](#list)
3. **[注意事项](#focus)**  
4. **[参考链接](#ref)** 


# <a id="info">1. 介绍</a>
「Nuts-SpringBoot-Single」基于org.springframework.boot的2.2.5.RELEASE版本进行开发的，并采用Gradle进行项目构建。
由于Gradle是初次使用，且org.springframework.boot采用的版本也是项目开发时最新的版本，不推荐应用到实际生产项目中。
过程中参考的开源项目会列到参考文献章节中，感谢其作者的无私奉献。  

<p align="right"><a href="#">返回顶部</a></p>  

## <a id="dev">1.1. 开发环境</a>  
- **JDK 1.8.0_211+**
- **Gradle 5.2+**
- **IntelliJ IDEA ULTIMATE 2019.1+**

> **提示：**项目中使用的其他组件版本及其配置要求会在`README-[组件名称].md`文件中进行详细的描述。
> 具体请参阅`README-[组件名称].md文件`  

<p align="right"><a href="#">返回顶部</a></p>  

## <a id="word">1.2. 术语与缩写解释</a>  
| 术语、缩写 | 解释 |
| --- | --- |
| *「术语、缩写」* | *对「术语、缩写」的解释说明。* |
| | |
> **提示：**列出本文档中的相关术语、缩写的解释。


<p align="right"><a href="#">返回顶部</a></p>  

# <a id="soft">2. 软件结构</a>
## <a id="dir">2.1. 项目目录结构</a>  
| 文件/目录名称   | 文件/目录介绍    |
| --- | --- |
| src | 源码目录，项目根目录中的src未存放源码，源码分布在具体的`Module`中  |
| build.gradle | 可以理解为一个Project框架，文件包含项目构建所使用的脚本。 |
| gradle | 包含wrapper路径,可以利用它进行安装项目默认的gradle. |
| gradlew | linux下的构建命令脚本，与使用已安装的Gradle运行构建是一样的。 |
| gradlew.bat | windows下的构建命令脚本，与使用已安装的Gradle运行构建是一样的。 |
| setting.gradle | 包含必要的一些设置，例如，任务或项目之间的依懒关系等. |
| README.md | 项目说明文档 |
| [README-gradle.md](./README-gradle.md) | Gradle介绍及相关配置说明 |
| [nuts-springboot-boot](./nuts-springboot-boot/README-boot.md) | nuts-springboot-boot介绍及相关配置说明 |
| `Module`  | 其他Module项目，具体Module说明，请参阅Module项目中的`README-[module].md`文件 |
| | |

<p align="right"><a href="#">返回顶部</a></p>  

## <a id="list">2.2. Module列表</a>
## Module列表
| Module名称| Module介绍 |
| --- | --- |
| *nuts-springboot-boot* | *工程引导项目* |
| | |

> **提示：**这里Module列是指相对独立的软件设计单元，即项目中的子模块项目。

<p align="right"><a href="#">返回顶部</a></p>  

# <a id="focus">3. 注意事项</a>  
| 框架、组件 | 注意事项   |
| --- | --- |
| *「框架、组件」* | *「框架、组件」的引入/配置的注意事项。* |
| | |

> **提示：**列出项目开发中引入其他框架或技术需要特别关注或配置的事项。

<p align="right"><a href="#">返回顶部</a></p>  

# <a id="ref">4. 参考链接</a>  
| 框架、组件 | 参考链接   | 关键概念/步骤   |
| --- | --- | --- |
| 「spring-boot-demo」 | https://github.com/xkcoding/spring-boot-demo | 包括60多个常用组件的集成Demo |
| *「框架、组件」* | *「框架、组件」的参考链接* | *其中的关键概念/步骤* |
| | | |

> **提示：**列出本文档的所有参考文献（可以是非正式出版物，或是开源项目）.  

<p align="right"><a href="#">返回顶部</a></p>  

&copy;Copyright 2020 Sleeber(anch8apparition@163.com) Apache License 2.0, 详情见 LICENSE 文件。
