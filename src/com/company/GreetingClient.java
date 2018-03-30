package com.company;

import java.io.*;
import java.net.Socket;

public class GreetingClient {

    public static void main(String[] args){
        String serverName = args[0];
        int port =Integer.parseInt(args[1]);

        try{
            System.out.println("连接到主机：" + serverName + " 端口：" + port);
            Socket client = new Socket(serverName, port);
            System.out.println("远程主机的地址：" + client.getRemoteSocketAddress());

            OutputStream outputStream = client.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            dataOutputStream.writeUTF("Hello From " + client.getLocalSocketAddress());

            InputStream inFromServer = client.getInputStream();

            DataInputStream dataInputStream = new DataInputStream(inFromServer);
            String dataFromServer = dataInputStream.readUTF();
            System.out.println("服务器响应：" + dataFromServer);

            client.close();

        }catch (IOException e){

        }
    }
}
