package com.example.networktest;
import android.net.IpSecManager;

import java.io.*;
import java.net.*;

public class TCPClient {

    public static void main(String[] args) throws Exception {
        serverRequest("01507521");
    }
    public static String serverRequest(String input) throws Exception {

        String output;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("se2-isys.aau.at",53212);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        input = inFromUser.readLine();

        outToServer.writeBytes(input+ '\n');

        output = inFromServer.readLine();

        return output;

    }

}
