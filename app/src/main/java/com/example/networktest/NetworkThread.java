package com.example.networktest;

public class NetworkThread extends Thread{

    String output;

    public void run(){
        TCPClient client = new TCPClient(MainActivity.input);

        try {
           output =  client.run();
           MainActivity.outputServer = output;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
