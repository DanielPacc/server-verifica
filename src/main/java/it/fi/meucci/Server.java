package it.fi.meucci;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.ArrayList;


public class Server {
    ServerSocket server; 
    public Server(){
        try{
        server = new ServerSocket(6789);
        }
        catch(Exception e){}

    }
    

    ArrayList <DThread> listaT = new ArrayList();
    public void attendi() {
        try {
           
            for(;;) { 
                System.out.println("1, server in attesa");
                Socket socket = server.accept();
                System.out.println("2, server partito" + socket);
                DThread ST = new DThread(socket);
                
                listaT.add(ST);
                ST.start();
            }
            

        } catch (Exception e) {
        }
    }

}