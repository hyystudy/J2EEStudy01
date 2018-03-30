package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class GreetingServer extends Thread {

    private final ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    @Override
    public void run() {
        //super.run();

        while (true){
            System.out.println("等待远程链接， 端口为：" + serverSocket.getLocalPort());

            try {
                Socket accept = serverSocket.accept();
                System.out.println("远程主机地址是:" + accept.getRemoteSocketAddress());
                DataInputStream dataInputStream = new DataInputStream(accept.getInputStream());
                System.out.println(dataInputStream.readUTF());

                DataOutputStream dataOutputStream = new DataOutputStream(accept.getOutputStream());
                dataOutputStream.writeUTF("谢谢链接我:" + accept.getLocalSocketAddress() + "\nGoodBye");

                serverSocket.close();
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(args[0]);
        GreetingServer greetingServer = new GreetingServer(port);
        greetingServer.run();
    }
}
