# [Optilog-Client](https://github.com/OptiJava/Optilog-Client/)

![Build](https://img.shields.io/badge/Build-Passing-green)
![Statistic](https://img.shields.io/badge/Code-3379Line-red)
[![Latest-Release](https://img.shields.io/badge/Release-Latest-blue)](https://github.com/OptiJava/Optilog-Client/releases/latest)

[中文](https://github.com/OptiJava/Optilog-Client/blob/master/README.md) |
[English](https://github.com/OptiJava/Optilog-Client/blob/master/README-en.md)

**_欢迎Star或Fork以支持本项目的开发工作！_**

这是一个用java语言编写的开源日志框架，他相比现在其他开源日志框架（比如log4j,slf4j）有更多的[优势](https://github.com/OptiJava/Optilog-Client#optilog%E7%9A%84%E4%BC%98%E5%8A%BF)

Optilog的Wiki随时会更新，有问题或者发现了bug在[Issues](https://github.com/OptiJava/Optilog-Client/issues)
或[Discussions](https://github.com/OptiJava/Optilog-Client/discussions)上提。

使用前一定！看[本项目Wiki](https://github.com/OptiJava/Optilog-Client/wiki)

_如果你愿意，欢迎Fork这个仓库为Optilog做出贡献，本项目的代码比较基础，任何人都可以做出贡献。非常欢迎向本项目发送PullRequest，哪怕只是改改文档也好。_
想要快速了解本项目的话，推荐看[Optilog的具体日志流程图](https://github.com/OptiJava/Optilog-Client/blob/master/Optilog.png)

## Optilog的优势

0.~~更新快（log4j和slf4j都几年没更新了）~~

1.性能高:
在初始化后，再输出一条日志（输出到屏幕+输出到文件+通过socket输出到服务端）最快只需要30毫秒（后续还会再优化）。而且Optilog是同步日志，完全没有延迟，也无需考虑多线程原子操作问题，log4j虽然是异步，但输出一条至少200毫秒。Optilog占用内存略小于log4j，输出一条日志约占502344字节

2.占位符方便：Optilog支持无限个占位符，并且可以重复使用（#1 #1输出两次第一个占位符），log4j只支持9个占位符

3.配置文件可以放在任意位置，配置文件名字不限，支持两种配置文件，在log4j中配置文件只能在classpath中且名字只能是log4j2.xml

4.支持客户端发送日志到[服务端](https://github.com/OptiJava/Optilog-Server)

5.Optilog内部可能出现的异常基本全部被捕获，不影响主要逻辑

6.只需一个jar包，打进classpath就能直接用（用gradle的不知道一下子加几十个jar包的感受）

7.适用于初学者，没有复杂的配置文件

8.需要的依赖少

9.日志中输出的Class、Method等信息是绝对准确的，因为Optilog内部使用StackTraceElement确定这些信息，并且无需在初始化日志时写入Class实例

10.Optilog可以直接生成一个默认的配置文件，初学者不用找配置文件范例（[教程](https://github.com/OptiJava/Optilog-Client/wiki/%E6%9B%B4%E5%A4%9A%E5%8A%9F%E8%83%BD#%E5%85%AD%E7%94%9F%E6%88%90%E9%BB%98%E8%AE%A4%E7%9A%84%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6)
）

11.支持多种格式的配置文件，包括json,yaml,xml和properties，后续还会增加对toml配置文件的支持

12.Optilog支持在运行期修改配置，当然只能修改true和false的一些配置项，输出文件路径什么的不能修改（以后会加入相关的功能，像packingFormat这类东西可以就直接修改了，如果真要修改输出路径可能要在内部重新初始化一下）

13.支持输出日志到jdbc

## Optilog输出日志预览：

![image](https://user-images.githubusercontent.com/106148777/170864247-7da18dd5-f5b9-4e5c-aee7-4174d29a8969.png)
_使用[carbon.now.sh](https://carbon.now.sh)生成_

## Dependency:

`com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.13.3`
\
`org.yaml:snakeyaml:1.30`
\
`mysql:mysql-connector-java:8.0.29`
\
（如果你只用properties作为配置文件的话Gson，Jackson，snakeyaml也可以不加，mysql不用也可以不加)

## Contributor:

`JavaUserO`

## 未来计划

实现远程调用
