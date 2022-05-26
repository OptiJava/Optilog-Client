package com.optilog.log.client;

import com.optilog.log.Optilog;
import com.optilog.util.OnlyInInit;
import com.optilog.util.OnlyInLog;

import java.io.IOException;
import java.net.*;

public class Client {
    @OnlyInInit
    public static void startClient(Optilog instance) {
        if (instance.consoleFileMasterCaution & instance.allSetting.startClient) {
            try {
                instance.socket = new DatagramSocket();
                instance.socket.setSoTimeout(1000);
                instance.socket.connect(InetAddress.getByName(instance.allSetting.host), instance.allSetting.socketNumber);
            } catch (UnknownHostException | SocketException exception) {
                System.out.println("Optilog Note:Exception in init client.");
                exception.printStackTrace();
            }
        }
        
    }
    
    @OnlyInLog
    public static void send(String msg, Optilog instance) {
        try {
            if (instance.consoleFileMasterCaution) {
                instance.socket.send(new DatagramPacket(msg.getBytes(), msg.getBytes().length));
            }
        } catch (IOException e) {
            instance.error("Optilog Note:IOException in Client.", e);
        }
    }
    
    @OnlyInLog
    public static void stop(Optilog instance) {
        instance.socket.disconnect();
        instance.info("Optilog Note:Socket Disconnected!");
    }
}
