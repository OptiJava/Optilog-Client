package com.optilog.log.client;

import com.optilog.log.Optilog;
import com.optilog.util.OnlyInInit;
import com.optilog.util.OnlyInLog;

import java.io.IOException;
import java.net.*;

public class Client {
    @OnlyInInit
    public static void initAppender(Optilog instance) {
        if (instance.allSetting.startClient) {
            try {
                instance.socket = new DatagramSocket();
                instance.socket.setSoTimeout(1000);
                instance.socket.connect(InetAddress.getByName(instance.allSetting.host), instance.allSetting.socketNumber);
            } catch (UnknownHostException | SocketException exception) {
                System.err.println("Optilog Note: Exception in init client.");
                exception.printStackTrace();
            }
        }
    }

    @OnlyInLog
    public static void logAppender(String msg, Optilog instance) {
        try {
            if (instance.allSetting.startClient) {
                instance.socket.send(new DatagramPacket(msg.getBytes(), msg.getBytes().length));
            }
        } catch (PortUnreachableException pue) {
            if (instance.allSetting.forceDisableSocketWhenException) {
                instance.allSetting.serverInfo = false;
                instance.allSetting.serverError = false;
                instance.allSetting.serverWarn = false;
                instance.allSetting.serverFatal = false;
                instance.allSetting.serverDebug = false;
                instance.error("Optilog Note: Force disabled socket because exception when send packet.", pue);
            } else {
                instance.error("Optilog Note: PortUnreachableException in Client.", pue);
            }
        } catch (IOException e) {
            instance.error("Optilog Note: IOException in Client.", e);
        }
    }

    @OnlyInLog
    public static void stop(Optilog instance) {
        instance.socket.disconnect();
        instance.info("Optilog Note: Socket Disconnected!");
    }
}
