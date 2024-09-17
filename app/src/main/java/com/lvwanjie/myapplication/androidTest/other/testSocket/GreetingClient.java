package com.lvwanjie.myapplication.androidTest.other.testSocket;


import java.net.*;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

public class GreetingClient {
    public static void main(String[] args) {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        try {
            MyLog.print("连接到主机：" + serverName + " ，端口号：" + port);
            Socket client = new Socket(serverName, port);
            MyLog.print("远程主机地址：" + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            MyLog.print("服务器响应： " + in.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect(){
        Timer timer = new Timer();

            String serverName = "127.0.0.1";
            int port = 6099;
            try {
                MyLog.print("连接到主机：" + serverName + " ，端口号：" + port);
                Socket client = new Socket(serverName, port);
                MyLog.print("远程主机地址：" + client.getRemoteSocketAddress());
                OutputStream outToServer = client.getOutputStream();
                DataOutputStream out = new DataOutputStream(outToServer);
                out.writeUTF("Hello from " + client.getLocalSocketAddress());
                out.flush();
                MyLog.print("start timer");
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            MyLog.print("time schedule");
                            out.writeUTF("hello 2");
                            InputStream inFromServer = client.getInputStream();
                            DataInputStream in = new DataInputStream(inFromServer);
                            MyLog.print("服务器响应： " + in.readUTF());
                            client.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }

                    }
                },2000);

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
