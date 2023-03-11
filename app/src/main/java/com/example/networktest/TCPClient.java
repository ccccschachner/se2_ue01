package com.example.networktest;
import java.io.*;
import java.net.*;

public class TCPClient {

    public static String run(String input) throws Exception {

        String sentence;
        String serverResponse;
        String calculation;
        int even=0;
        int odd=0;
        int temp=0;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("se2-isys.aau.at", 53212);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        sentence = input;

        outToServer.writeBytes(sentence + '\n');

        serverResponse = inFromServer.readLine();

        //alternierende Quersumme bilden
        for (int i =0; i<sentence.length(); i++){
            temp = Integer.parseInt(sentence.charAt(i)+"");
            even+=temp;
        }

        for (int i=1; i<sentence.length();i++){
            temp = Integer.parseInt(sentence.charAt(i)+"");
            odd+=temp;
        }

        temp = even-odd;
        if (temp%2==0){
            calculation = "Gerade.";
        }
        else{
            calculation = "Ungerade.";
        }

        clientSocket.close();

        System.out.println("From Server: " + serverResponse);

        return calculation;


    }
}
