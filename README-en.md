# [Optilog-Client](https://github.com/OptiJava/Optilog-Client)

![Build](https://img.shields.io/badge/Build-Passing-green)
[![Latest-Release](https://img.shields.io/badge/Release-Latest-blue)](https://github.com/OptiJava/Optilog-Client/releases/latest)

[中文](https://github.com/OptiJava/Optilog-Client/blob/master/README.md) |
[English](https://github.com/OptiJava/Optilog-Client/blob/master/README-en.md)

**This is an open source logging framework written in Java language. It has more advantages than other open source
logging frameworks (such as log4j and slf4j)**

The wiki of optilog will be updated at any time. Problems or bugs will be raised
on [issues](https://github.com/OptiJava/Optilog-Client/issues)
or [discussions](https://github.com/OptiJava/Optilog-Client/discussions).

**Be sure to read the [wiki](https://github.com/OptiJava/Optilog-Client/wiki) of this project before using it**

_If you like, you are welcome to contribute to optilog through fork. The code of this project is quite basic, and anyone
can contribute,**Thank you all for supporting this project**_

## Optilog advantages

1. high performance: After initialization, another log (output to the screen + output to a file + output to the server
   through socket) can be output as fast as 8 milliseconds (it will be optimized later). Log4j should be at least 41
   milliseconds.

2. Placeholder convenience: optilog supports unlimited placeholders and can be reused (#1 #1 outputs the first
   placeholder twice). Log4j only supports 9 placeholders.

3. Configuration file can be placed in any location. The name of the configuration file is unlimited. Two types of
   configuration files are supported. In log4j, the configuration file can only be in classpath and the name can only be
   log4j2 xml.

4. Support the client to send logs to [Server](https://github.com/OptiJava/Optilog-Server).

5. All possible exceptions in Optilog are basically captured without affecting the main logic.

6. You only need one jar package, and you can use it directly by typing in the classpath (I don't know the feeling of
   adding dozens of jar packages at once when using gradle).

7. Suitable for beginners without complex configuration files.

8. Few [dependence](https://github.com/OptiJava/Optilog-Client/blob/master/README-en.md#dependency).

9. Class, method and other information output in the log are absolutely accurate, because Optilog uses StackTraceElement
   internally to determine that information, and there is no need to write the class instance when initializing the
   log.

10. Optilog can directly generate a default configuration file. Beginners do not need to look for the configuration file
    example ([Tutorial](https://github.com/OptiJava/Optilog-Client/wiki/%E6%9B%B4%E5%A4%9A%E5%8A%9F%E8%83%BD#%E5%85%AD%E7%94%9F%E6%88%90%E9%BB%98%E8%AE%A4%E7%9A%84%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6))

11. Support configuration files in multiple formats, including JSON, yaml, XML and properties. Support for .toml
    configuration files will be added later.

12. Optilog supports configuration modification during runtime. Of course, only some configuration items of true and
    false can be modified. Output file paths cannot be modified(Related functions will be added in the future. Things
    like packingFormat can be modified directly. If you really want to modify the output path, you may need to
    reInitialize it internally).

13. Support outputting logs to JDBC.

## Optilog log picture:

![image](https://user-images.githubusercontent.com/106148777/170864247-7da18dd5-f5b9-4e5c-aee7-4174d29a8969.png)
_Generate by [carbon.now.sh](https://carbon.now.sh)_

## Dependency:

`com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.13.3`
\
`org.yaml:snakeyaml:1.30` `mysql:mysql-connector-java:8.0.29`
\
`mysql:mysql-connector-java:8.0.29`
\
(You needn't add dependency if you don't use these function.)

## Author:

OptiJava

## Contributor:

JavauserO

## Future plans

realize remote call
