package com.netty.nettyspringboot.client;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketClient {

    @Test
    void socketTest() throws IOException {
        Socket socket = null;

        try {
            socket = new Socket();
            System.out.println("\n[ Request ... ]\n");
            socket.connect(new InetSocketAddress("localhost", 8081));
            System.out.println("\n[ Success ... ]\n");

            byte[] bytes = null;
            String message = null;
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            message = "IF0002  ㅎㅎ    NEXT0112345678901234567890123456789099INQ0001 2021012920210129";
            bytes = message.getBytes("UTF-8");

            dos.write( ( String.format("%04d", bytes.length) + message).getBytes(StandardCharsets.UTF_8));
            dos.flush();

            System.out.println("\n[ Data Send Success ]\n" + message);

            InputStream is = socket.getInputStream();

            byte[] data = new byte[4];
            int bLen = is.read(data, 0, 4);
            if(bLen == -1) {
                return;
            }
            int length = Integer.parseInt(new String(data));

            byte[] recevie = new byte[length];
            int len = is.read(recevie, 0, length);
            System.out.println("\n[ Data Received ]\n" + new String(recevie));

            os.close();
            is.close();

            socket.close();
            System.out.println("\n[ Socket closed ]\n");

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!socket.isClosed()) {
            try {
                socket.close();
                System.out.println("\n[ Socket closed ]\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
