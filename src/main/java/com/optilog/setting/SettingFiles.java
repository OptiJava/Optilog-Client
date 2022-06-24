package com.optilog.setting;

import com.optilog.log.Optilog;
import com.optilog.util.OnlyInInit;
import com.optilog.util.exception.ConfigureException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class SettingFiles {
    public boolean printError = true;
    public boolean printInfo = true;
    public boolean printDebug = true;
    public boolean printWarn = true;
    public boolean printFatal = true;
    public String defaultConsolePath = "";
    public String Path1 = "";
    public String Path2 = "";
    public String Path3 = "";
    public String Path4 = "";
    public String Path5 = "";
    public String infoPath = "";
    public String errorPath = "";
    public String warnPath = "";
    public String debugPath = "";
    public String fatalPath = "";
    public boolean consoleInfo = true;
    public boolean consoleError = true;
    public boolean consoleDebug = true;
    public boolean consoleWarn = true;
    public boolean consoleFatal = true;
    public boolean serverInfo = false;
    public boolean serverError = false;
    public boolean serverDebug = false;
    public boolean serverWarn = false;
    public boolean serverFatal = false;
    public boolean startClient = false;
    public String host = "localhost"; // localhost
    public int socketNumber = 65535;
    public String printPackingFormat = "[%yyyy-%MM-%dd|%HH:%mm:%ss(%SS)][%class %method(%file:%line)/%thread] %level:%msg";
    public String consolePackingFormat = "[%yyyy-%MM-%dd|%HH:%mm:%ss(%SS)][%class %method(%file:%line)/%thread] %level:%msg";
    public String serverPackingFormat = "[%yyyy-%MM-%dd|%HH:%mm:%ss(%SS)][%class %method(%file:%line)/%thread] %level:%msg";

    public String fileName = "%time Log(Client).log";

    @OnlyInInit
    public static void check(String str, Optilog instance) throws IOException {
        if (!str.isBlank()) {
            if (str.startsWith("%json -cp")) {
                JsonSettings.getJsonSettings(str.substring(10), true, instance);
                return;
            }

            if (str.startsWith("%json ")) {
                JsonSettings.getJsonSettings(str.substring(6), false, instance);
                return;
            }
            if (str.startsWith("%xml -cp ")) {
                XmlSettings.xml(str.substring(9), true, instance);
                return;
            }
            if (str.startsWith("%xml ")) {
                XmlSettings.xml(str.substring(5), false, instance);
                return;
            }
            if (str.startsWith("%prop -cp ")) {
                String s = str.substring(10);
                try (InputStream input = Optilog.class.getResourceAsStream(s)) {
                    if (input == null) {
                        instance.consoleFileMasterCaution = false;
                        System.err.println("Optilog Note: Can't find'" + s + "'in classpath.");
                        throw new ConfigureException("Can't find'" + s + "'in classpath.");
                    }
                    PropSettings.properties(input, instance);
                    return;
                }
            }
            if (str.startsWith("%prop ")) {
                String s = str.substring(6);
                try (InputStream input = new FileInputStream(s)) {
                    PropSettings.properties(input, instance);
                    return;
                }
            }
            if (str.startsWith("%yaml -cp ")) {
                YamlSettings.yaml(str.substring(10), true, instance);
                return;
            }
            if (str.startsWith("%yaml ")) {
                YamlSettings.yaml(str.substring(6), false, instance);
                return;
            }
            if (str.startsWith("%slf4j -cp ")) {
                Slf4jSettings.xmlSlf4j(str.substring(11), true, instance);
                return;
            }
            if (str.startsWith("%slf4j ")) {
                Slf4jSettings.xmlSlf4j(str.substring(7), false, instance);
                return;
            }
            instance.consoleFileMasterCaution = false;
            System.err.println("Argument illegal or that Configure file not be supported");
        }
    }

    @OnlyInInit
    public static String readAsString(InputStream input) throws IOException {
        int n;
        StringBuilder sb = new StringBuilder();
        while ((n = input.read()) != -1) {
            sb.append((char) n);
        }
        return sb.toString();
    }

    public static void generatePropertiesSettings(String path) {
        File f = new File(path + "//Setting.properties");
        try {
            if (!f.createNewFile()) {
                throw new IOException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.writeString(f.toPath(), "# print\n" +
                    "print.info=true\n" +
                    "print.error=true\n" +
                    "print.warn=true\n" +
                    "print.debug=true\n" +
                    "print.fatal=true\n" +
                    "print.packingFormat=[%yyyy-%MM-%dd|%HH:%mm:%ss(%SS))][%class %method(%file:%line)/%thread] %level:%msg\n" +
                    "# file\n" +
                    "file.defaultConsolePath=(path to your logs directory)\n" +
                    "#file.Path1=(path to your logs directory)." +
                    "#file.infoPath=%path1\n" +
                    "#file.debugPath=%path1\n" +
                    "#file.warnPath=%path1\n" +
                    "file.consoleInfo=true\n" +
                    "file.consoleDebug=true\n" +
                    "file.consoleError=true\n" +
                    "file.consoleWarn=true\n" +
                    "file.consoleFatal=true\n" +
                    "file.fileName=%timeLog.log\n" +
                    "file.packingFormat=[%yyyy-%MM-%dd|%HH:%mm:%ss(%SS))][%class %method(%file:%line)/%thread] %level:%msg\n" +
                    "# server\n" +
                    "server.infoSendToServer=true\n" +
                    "server.errorSendToServer=true\n" +
                    "server.warnSendToServer=true\n" +
                    "server.debugSendToServer=true\n" +
                    "server.fatalSendToServer=true\n" +
                    "server.startClient=true\n" +
                    "server.socketNumber=65535\n" +
                    "server.packingFormat=[%yyyy-%MM-%dd|%HH:%mm:%ss(%SS))][%class %method(%file:%line)/%thread] %level:%msg\n" +
                    "server.host=localhost", StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateXmlSettings(String path) {
        File f = new File(path + "//Setting.xml");
        try {
            if (!f.createNewFile()) {
                throw new IOException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.writeString(f.toPath(), "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                    "<Optilog>\n" +
                    "    <print>\n" +
                    "        <printInfo>true</printInfo>\n" +
                    "        <printError>true</printError>\n" +
                    "        <printWarn>true</printWarn>\n" +
                    "        <printDebug>true</printDebug>\n" +
                    "        <printFatal>true</printFatal>\n" +
                    "\n" +
                    "        <packingFormat>\n" +
                    "            [%yyyy-%MM-%dd|%HH:%mm:%ss(%SS))][%class %method(%file:%line)/%thread] %level:%msg\n" +
                    "        </packingFormat>\n" +
                    "    </print>\n" +
                    "\n" +
                    "    <file>\n" +
                    "        <consoleInfo>true</consoleInfo>\n" +
                    "        <consoleError>true</consoleError>\n" +
                    "        <consoleWarn>true</consoleWarn>\n" +
                    "        <consoleDebug>true</consoleDebug>\n" +
                    "        <consoleFatal>true</consoleFatal>\n" +
                    "\n" +
                    "        <defaultConsolePath>\n" +
                    "            (path to your logs directory)\n" +
                    "        </defaultConsolePath>\n" +
                    "\n" +
                    "        <fileName>%timeLog(Client).log</fileName>\n" +
                    "        <packingFormat>\n" +
                    "            [%yyyy-%MM-%dd|%HH:%mm:%ss(%SS))][%class %method(%file:%line)/%thread] %level:%msg\n" +
                    "        </packingFormat>\n" +
                    "    </file>\n" +
                    "\n" +
                    "    <server>\n" +
                    "        <serverInfo>true</serverInfo>\n" +
                    "        <serverError>true</serverError>\n" +
                    "        <serverWarn>true</serverWarn>\n" +
                    "        <serverDebug>true</serverDebug>\n" +
                    "        <serverFatal>true</serverFatal>\n" +
                    "\n" +
                    "        <startClient>false</startClient>\n" +
                    "        <host>localhost</host>\n" +
                    "        <socketNumber>65535</socketNumber>\n" +
                    "        <packingFormat>\n" +
                    "            [%yyyy-%MM-%dd|%HH:%mm:%ss(%SS))][%class %method(%file:%line)/%thread] %level:%msg\n" +
                    "        </packingFormat>\n" +
                    "    </server>\n" +
                    "</Optilog>", StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateYamlSettings(String path) {
        File f = new File(path + "//Setting.yaml");
        try {
            if (!f.createNewFile()) {
                throw new IOException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.writeString(f.toPath(), "info:\n" +
                    "  print: true\n" +
                    "  console: true\n" +
                    "  server: true\n" +
                    "error:\n" +
                    "  print: true\n" +
                    "  console: true\n" +
                    "  server: true\n" +
                    "warn:\n" +
                    "  print: true\n" +
                    "  console: true\n" +
                    "  server: true\n" +
                    "debug:\n" +
                    "  print: true\n" +
                    "  console: true\n" +
                    "  server: true\n" +
                    "fatal:\n" +
                    "  print: true\n" +
                    "  console: true\n" +
                    "  server: true\n" +
                    "print:\n" +
                    "  packingFormat: \"[%yyyy-%MM-%dd|%HH:%mm:%ss(%SS))][%class %method(%file:%line)/%thread] %level:%msg\"\n" +
                    "file:\n" +
                    "  defaultConsolePath: \"(path to your directory)\"\n" +
                    "  fileName: \"%timeLog.log\"\n" +
                    "  packingFormat: \"[%yyyy-%MM-%dd|%HH:%mm:%ss(%SS))][%class %method(%file:%line)/%thread] %level:%msg\"\n" +
                    "server:\n" +
                    "  startClient: true\n" +
                    "  socketNumber: 65535\n" +
                    "  host: \"localhost\"\n" +
                    "  packingFormat: \"[%yyyy-%MM-%dd|%HH:%mm:%ss(%SS))][%class %method(%file:%line)/%thread] %level:%msg\"\n", StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
