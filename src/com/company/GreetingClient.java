package com.company;

import java.io.*;
import java.net.Socket;

public class GreetingClient {

    public static void main(String[] args){
        String serverName = args[0];
        int port =Integer.parseInt(args[1]);

        try{
            System.out.println("Connected Server:" + serverName + " Port:" + port);
            Socket client = new Socket(serverName, port);
            System.out.println("Remote Server IP:" + client.getRemoteSocketAddress());

            OutputStream outputStream = client.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            dataOutputStream.writeUTF("Hello From" + client.getLocalSocketAddress());

            InputStream inFromServer = client.getInputStream();

            DataInputStream dataInputStream = new DataInputStream(inFromServer);
            String dataFromServer = dataInputStream.readUTF();
            System.out.println("Server Response:" + dataFromServer);

            client.close();

        }catch (IOException e){

        }
    }
}
