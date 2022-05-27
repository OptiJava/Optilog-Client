# Optilog

_截止目前，Optilog代码总量2247行！_

这是一个用java语言编写的开源日志框架。

使用前一！定！看本项目Wiki (https://github.com/OptiJava/Optilog-Client/wiki)

**_注意事项：_**
\
**一整个java项目建议全程只用一个初始化出来的实例，不然会出bug！在程序最后要调用log.shutdown()方法，否则程序就会一直等待下去。**

**Optilog的优势**

1.性能高:初始化日志+输出一条日志（输出到屏幕+输出到文件+通过socket输出到服务端） 最多只需要162毫秒（后续还会再优化），但在你的你不用这个log实例之后要调用log.shutdown()。

2.占位符方便：Optilog支持无限个占位符，并且可以重复使用（#1 #1输出两次第一个占位符）

3.配置文件可以放在任意位置，配置文件名字不限，支持两种配置文件，在log4j中配置文件只能在classpath中且名字只能是log4j2.xml

4.支持客户端发送日志到服务端

5.Optilog内部可能出现的异常全部被捕获，不影响主要逻辑

6.只需一个jar包，打进classpath就能直接用

7.适用于初学者，没有复杂的配置文件

8.需要的依赖少，只有一个Gson2.9.0

**Optilog的缺陷**

1.没有对jdbc的支持

2.不支持xml配置文件

3.文件输出路径的配置相对麻烦

**Dependency:**
\
`Gson-2.9.0`

**Author:**
\
`OptiJava`
