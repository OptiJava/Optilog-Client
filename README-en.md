# [Optilog-Client](https://github.com/OptiJava/Optilog-Client)

![Build](https://img.shields.io/badge/Build-Passing-green)
[![Latest-Release](https://img.shields.io/badge/Release-Latest-blue)](https://github.com/OptiJava/Optilog-Client/releases/latest)

[中文](https://github.com/OptiJava/Optilog-Client/blob/master/README.md) |
[English](https://github.com/OptiJava/Optilog-Client/blob/master/README-en.md)

**This is an open source logging framework written in java. Optilog has
more [advantages](https://github.com/OptiJava/Optilog-Client#optilog%E7%9A%84%E4%BC%98%E5%8A%BF) than other open source
logging frameworks (such as log4j and SLF4j)**

The wiki of Optilog will be updated at any time. If there is a problem, ask the issues. You should see this
project [wiki](https://github.com/OptiJava/Optilog-Client/wiki) before use Optilog.

[OptilogServer](https://github.com/OptiJava/Optilog-Server) matched with OptilogClient. See wiki for details.

If you like, you are welcome to contribute to Optilog through fork. The code of this project is quite basic. Anyone can
contribute.

## Optilog advantages

1.High performance: After initialization log, output a log (output to the screen + output to a file + output to the
server through socket) only takes 8 milliseconds at most (it will be optimized later), and log4j takes at least 41
milliseconds.

2.Optilog supports unlimited placeholders and can be reused (#1 #1 outputs the first placeholder twice). Log4j only
supports 9 placeholders.

3.The configuration file can be placed in any location. The name of the configuration file is unlimited. Two types of
configuration files are supported. In log4j, the configuration file can only be in classpath and the name can only be
log4j2 XML

4.Support the client to send logs to the server(See details in [wiki](https://github.com/OptiJava/Optilog-Client/wiki)'
s 'use OptilogServer' Page,Download OptilogServer in [OptilogServer](https://github.com/OptiJava/Optilog-Server))

5.All possible exceptions in optilog are captured without affecting the main logic

6.You only need one jar package, and you can use it directly by typing in the classpath (I don't know the feeling of
adding dozens of jar packages at once when using gradle)

7.Suitable for beginners without complex configuration files

8.There are few dependencies

9.Class, method and other information output in the log is absolutely accurate, because optilog uses stacktrace to
determine this information internally, and there is no need to write the class instance when initializing the log

10.Optilog can directly generate a default configuration file. Beginners do not need to look for configuration file
examples

11.Support configuration files in multiple formats, including JSON,YAML, XML and properties. Support for toml
configuration files will be added later

## Defects of optilog

1. No JDBC support <- On 2022/6/7,Optilog can send log to DataBase,Optilog already support jdbc!!!

## Optilog log picture:

![image](https://user-images.githubusercontent.com/106148777/170864247-7da18dd5-f5b9-4e5c-aee7-4174d29a8969.png)
_Generate by [carbon.now.sh](https://carbon.now.sh)_

## Dependency:

`com.google.code.gson:gson:2.9.0` `com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.13.3` `org.yaml:snakeyaml:1.30` `mysql:mysql-connector-java:8.0.29`(
You needn't add dependency if you don't use these
function.)

## Author:

OptiJava

## Contributor:

JavauserO

## Future plans

realize remote call
