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

_**Author:**_
\
`opti`