package com.optilog.log.client;

import com.optilog.log.Optilog;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void startClient(Optilog instance) {
        if (instance.allSetting.startClient) {
            try {
                instance.socket = new DatagramSocket();
                instance.socket.setSoTimeout(1000);
                instance.socket.connect(InetAddress.getByName("localhost"), instance.allSetting.socketNumber);
            } catch (UnknownHostException | SocketException var1) {
                var1.printStackTrace();
            }
        }
        
    }
    
    public static void send(String msg, Optilog instance) {
        try {
            byte[] data = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length);
            instance.socket.send(packet);
        } catch (IOException var3) {
            var3.printStackTrace();
        }
    }
    
    public static void stop(Optilog instance) {
        instance.socket.disconnect();
    }
}
