# [Optilog-Client](https://github.com/OptiJava/Optilog-Client/)

![Build](https://img.shields.io/badge/Build-Passing-green)
[![Latest-Release](https://img.shields.io/badge/Release-Latest-blue)](https://github.com/OptiJava/Optilog-Client/releases/latest)

[中文](https://github.com/OptiJava/Optilog-Client/blob/master/README.md) |
[English](https://github.com/OptiJava/Optilog-Client/blob/master/README-en.md)

_截止目前，Optilog代码总量3294行！_

这是一个用java语言编写的开源日志框架，他相比现在其他开源日志框架（比如log4j,slf4j）有更多的[优势](https://github.com/OptiJava/Optilog-Client#optilog%E7%9A%84%E4%BC%98%E5%8A%BF)

Optilog的Wiki随时会更新，有问题在Issues问，使用前一！定！看[本项目Wiki](https://github.com/OptiJava/Optilog-Client/wiki)

与OptilogClient配套的[OptilogServer](https://github.com/OptiJava/Optilog-Server).

_如果你愿意，欢迎Fork这个仓库为Optilog做出贡献，本项目的代码比较基础，任何人都可以做出贡献_

## Optilog的优势

1.性能高:在初始化后，再输出一条日志（输出到屏幕+输出到文件+通过socket输出到服务端） 最快只需要8毫秒（后续还会再优化），log4j至少41毫秒

2.占位符方便：Optilog支持无限个占位符，并且可以重复使用（#1 #1输出两次第一个占位符），log4j只支持9个占位符

3.配置文件可以放在任意位置，配置文件名字不限，支持两种配置文件，在log4j中配置文件只能在classpath中且名字只能是log4j2.xml

4.支持客户端发送日志到服务端

5.Optilog内部可能出现的异常全部被捕获，不影响主要逻辑

6.只需一个jar包，打进classpath就能直接用（用gradle的不知道一下子加几十个jar包的感受）

7.适用于初学者，没有复杂的配置文件

8.需要的依赖少

9.日志中输出的Class、Method等信息是绝对准确的，因为Optilog内部使用StackTrace确定这些信息，并且无需在初始化日志时写入Class实例

10.Optilog可以直接生成一个默认的配置文件，初学者不用找配置文件范例

11.支持多种格式的配置文件，包括json,yaml,xml和properties，后续还会增加对toml配置文件的支持

12.Optilog支持在运行期修改配置，当然只能修改true和false的一些配置项，输出文件路径什么的不能修改

## Optilog的缺陷

1.没有对jdbc的支持  <-在2022/6/7最新的提交中，已经新增了将日志输出到DataBase的支持~~你们肯定不知道我装mysql装了5遍才成功~~

## Optilog输出日志预览：

![image](https://user-images.githubusercontent.com/106148777/170864247-7da18dd5-f5b9-4e5c-aee7-4174d29a8969.png)
_使用[carbon.now.sh](https://carbon.now.sh)生成_

## Dependency:

`com.google.code.gson:gson:2.9.0`
\
`com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.13.3`
\
`org.yaml:snakeyaml:1.30`
\
`mysql:mysql-connector-java:8.0.29`
\
（如果你只用properties作为配置文件的话Gson，Jackson，snakeyaml也可以不加，mysql不用也可以不加)

## Author:

`OptiJava`

## Contributor:

`JavaUserO`

## 未来计划

实现远程调用
