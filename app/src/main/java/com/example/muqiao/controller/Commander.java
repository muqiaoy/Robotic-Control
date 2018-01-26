package com.example.muqiao.controller;

import java.io.PrintWriter;
import java.net.Socket;


/**
 * Created by muqiao on 16/7/27.
 */
public class Commander {
    public static String HOST =Address.getAddress();
    public static int PORT =8888;
    public static void send(Command forward) throws Exception {
        Socket socket = new Socket(HOST, PORT);
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        writer.println(forward.toString());
        writer.flush();
        socket.close();
    }

}
