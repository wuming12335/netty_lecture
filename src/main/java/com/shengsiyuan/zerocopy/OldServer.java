package com.shengsiyuan.zerocopy;

import java.net.ServerSocket;
import java.net.Socket;

public class OldServer {
    public static void main(String[] args)throws Exception {
        ServerSocket serverSocket = new ServerSocket(8899);

        while (true){
            Socket socket = serverSocket.accept();


        }
    }
}
