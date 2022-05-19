**_Optilog_**

这是一个用java语言编写的开源日志框架。（OpenOptilog）
<p>
先导入包 com.optilog.log.Optilog 和 com.optilog.log.Log
<pre>
import com.optilog.*;
...
Log log = Log.initLog("C:\\Settings\\Setting.json");
</pre>
你可以通过调用方法来输出日志
<pre>
log.info(someMessage);
log.debug(someMessage);
log.warn(someMessage);
log.error(someMessage);
</pre>
在日志中可以输出： int,
String,
char[],
object,
long,
short,
float and double,
但不能输出char.
 <p>
 一个例子：
 <pre>
 Log log = optilog.initlog(Main.class,"(path of setting file .json,if haven't,make it blank)");
 int n = 1;
 log.info("Start! " + n);
 </pre>
 输出结果
 <pre>
 [2022-03-25|09:06:04][(package)] info: Start! 1
 </pre>
 如果你需要重新实例化日志接口，你需要调用reInitLog方法：
 <pre>
 Log log = optilog.reInitLog();
 </pre>
 <p>
 配置文件实例：
 <pre>
"printPath": "D:\\work\\.\\logs",  -> console file path
"printInfo": true,     -> print info on screen
"printDebug": true,    -> print debug on screen
"printWarn": true,     -> print warn on screen
"printError": true,    -> print error on screen
"printCommand": true,  -> print command result on screen

"consoleInfo": true, -> console info to file
"consoleDebug": true, -> console debug to file
"consoleError": true, -> console error to file
"consoleWarn": true -> console warning to file
</pre>

**_Dependency:_**
\
`Gson-2.9.0`

**_Changelogs:_**
\
1.3  **(Latest)**
\
`1.修复了服务器输出空行的bug`
\
`2.新增了指令（仅服务端）{StopServer}`

1.3-ServerTest
\
`1.新增了Optilog服务器，日志可以上传至服务器`

1.2.1
\
`1.修复了很多bug,提高了运行效率`

~~1.2~~
\
`1.现在@ConsoleInLog可以输出private字段了`
\
`2.Optilog内部进行了大重写，使得日志变得更加安全、效率高，也提升了可扩展性`
\
`3.修复了一些被抛出但未打印的异常`
\
`4.修复了有些异常未结束运行导致更严重异常被抛出的问题`
\
`5.修复了有些异常被抛出两次的问题`
\
`6.修复了不检查路径是否为null的问题`
\
`7.修复了一些未预料到的异常`

~~1.1.1~~
\
`1.修复了@ConsoleInLog一个类只能注解一次的bug`

~~_1.1_~~
\
`1.在输出时显示线程名和当前的栈信息`
\
`2.使日志在运行时安全性更高`
\
`3.添加了一个注解@ConsoleInLog,注解在字段上会输出这个字段的值，但目前有bug，一个类只能注解一次`

~~_1.0_~~
\
`1.修复reInit方法`
\
`2.为日志提供了接口`
\
`3.删除了所有的命令（共两个）`

~~_1.0-SNAPSHOT:_~~
\
`1.加入了日志`
\
`2.加入了日志输出到文件的功能`
\
`3.加入了读取配置文件的功能`

_**Author:**_
\
`opti`