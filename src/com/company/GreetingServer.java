package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 通过cmd 操作.java文件的时候，如果这个java文件有package， 那么我们需要在
 * package的父文件夹 执行命令：java 文件全路径 参数
 * 以这个文件为例子：
 * 先cd 到 src 目录下 然后
 * javac com/company/GreetingServer.java
 * 得到编译文件 然后
 * java com/company/GreetingServer 6066
 * */
public class GreetingServer extends Thread {

    private final ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(100000);
    }

    @Override
    public void run() {
        //super.run();

        while (true){
            System.out.println("Waiting connected, Port:" + serverSocket.getLocalPort());

            try {
                Socket accept = serverSocket.accept();
                System.out.println("Remote Client IP Address:" + accept.getRemoteSocketAddress());
                DataInputStream dataInputStream = new DataInputStream(accept.getInputStream());
                System.out.println(dataInputStream.readUTF());

                DataOutputStream dataOutputStream = new DataOutputStream(accept.getOutputStream());
                dataOutputStream.writeUTF("Thanks to connected me :" + accept.getLocalSocketAddress() + "\nGoodBye");

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
