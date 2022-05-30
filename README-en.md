# Optilog

**This is an open source logging framework written in java. Optilog has more [advantages](https://github.com/OptiJava/Optilog-Client#optilog%E7%9A%84%E4%BC%98%E5%8A%BF) than other open source logging frameworks (such as log4j and slf4j)**

The wiki of Optilog will be updated at any time. If there is a problem, ask the issues. You should see this
project [wiki](https://github.com/OptiJava/Optilog-Client/wiki) before use Optilog.

[OptilogServer](https://github.com/OptiJava/Optilog-Server) matched with this(OptilogClient). See wiki for details.

If you like, you are welcome to contribute to Optilog through fork. The code of this project is quite basic. Anyone can
contribute. ~~Including those who can't coding, because they can write tutorial~~

# Precautions:

For a whole java project, it is recommended to use only one initialized instance in the whole process, otherwise there
will be a bug! (see wiki for details)(expect when you need change setting file)

# Optilog advantages

1.High performance: Initialization log + output a log (output to the screen + output to a file + output to the server
through socket) only takes 130 milliseconds at most (it will be optimized later), and log4j takes at least 300
milliseconds.

2.Optilog supports unlimited placeholders and can be reused (#1 #1 outputs the first placeholder twice). Log4j only
supports 9 placeholders

3.The configuration file can be placed in any location. The name of the configuration file is unlimited. Two types of
configuration files are supported. In log4j, the configuration file can only be in classpath and the name can only be
log4j2 XML

4.Support the client to send logs to the server(See details in [wiki](https://github.com/OptiJava/Optilog-Client/wiki)'
s 'use
OptilogServer' Page,Download OptilogServer in [OptilogServer](https://github.com/OptiJava/Optilog-Server))

5.All possible exceptions in optilog are captured without affecting the main logic

6.You only need one jar package, and you can use it directly by typing in the classpath (I don't know the feeling of
adding dozens of jar packages at once when using gradle)

7.Suitable for beginners without complex configuration files

8.There are few dependencies, only one Gson2.9.0 and Jackson format XML

9.Class, method and other information output in the log is absolutely accurate, because optilog uses stacktrace to
determine this information internally, and there is no need to write the class instance when initializing the log

10.optilog can directly generate a default configuration file. Beginners do not need to look for configuration file
examples

11.Support configuration files in multiple formats, including JSON, XML and properties. Support for yaml and toml
configuration files will be added later

# Defects of optilog

1. No JDBC support

2. XML configuration files are not supported <- in the latest submission, optilog already supports XML format
   configuration files

3. The configuration of file output path is relatively troublesome <- this defect has been solved, and the defects of
   optilog will be solved one after another

# Optilog log picture:
![image](https://user-images.githubusercontent.com/106148777/170864247-7da18dd5-f5b9-4e5c-aee7-4174d29a8969.png)

# Dependency:

Gson-2.9.0 jackson-dataformat-xml-2.13.3

# Author:

Optijava

# Contributor:

JavauserO

# Future plans

add support for XML format configuration files (implemented)

realize remote call
