**_Optilog_**

这是一个用java语言编写的开源日志框架。（OpenOptilog）
<p>
先导入包 com.optilog.log.Log
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
 Log log = optilog.initlog("(path of setting file .json,if haven't,make it blank)");
 或Log log = optilog.initlog("-prop (path of setting file .properties,if haven't,make it blank)");
 或Log log = optilog.initlog("-prop -cp (path of setting file .properties in classpath,if haven't,make it blank)");
 或Log log = optilog.initlog("=-cp (path of setting file .json in classpath,if haven't,make it blank)");
 int n = 1;
 log.info("Start! " + n);
 </pre>
 输出结果
 <pre>
 [2022-03-25|09:06:04][(package)] info: Start! 1
 </pre>
 <p>
 配置文件实例：
 <pre> (以properties为示范)
printInfo=true
printError=true
printWarn=true
printDebug=true
printFatal=true
#defaultConsolePath=D:\\Program\\resources\\logs
Path1=D:\\Program\\test\\resources\\logs
Path2=D:\\Program\\test
infoPath=%path1
errorPath=%path2
warnPath=%path1
debugPath=%path1
fatalPath=%path2
consoleInfo=true
consoleDebug=true
consoleError=true
consoleWarn=true
consoleFatal=true
infoSendToServer=true
errorSendToServer=true
warnSendToServer=true
debugSendToServer=true
fatalSendToServer=true
startClient=true
socketNumber=65535
packingFormat=[%yyyy-%MM-%dd|%HH:%mm:%ss(%SS))][%class %method(%file:%line)/%thread] %level:%msg
fileName=%timeLog.log
</pre>

**_Dependency:_**
\
`Gson-2.9.0`

_**Author:**_
\
`opti`