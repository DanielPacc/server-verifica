package it.fi.meucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import com.fasterxml.jackson.databind.ObjectMapper;


public class DThread extends Thread {
    Socket socket = null;
    String stringaRicevuta = null;
    BufferedReader indalClient;
    DataOutputStream outversoClient;
    static Messaggio msg;
    ObjectMapper mapper;

    //ArrayList
    public DThread(Socket s) throws Exception {
        socket = s;
        mapper = new ObjectMapper();
        indalClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outversoClient = new DataOutputStream(socket.getOutputStream());
    
    }

    public void run() {
        while(true){
            String str;
            try {
                // Input socket
                str = indalClient.readLine();
                System.out.println("Read " + str + ".");
                String mess ="";
                mess=mess+mapper.writeValueAsString(msg.toString());
                System.out.println("ricevuto: " );
                outversoClient.writeBytes(mess + ", Scrivi quanti biglietti vuoi comprare: "+ "\n");
                str = indalClient.readLine();
                int in=Integer.parseInt(str);
                for(int i=0; i<in; i++){//con questo ciclo mi faccio dare dal client sia il numero dei biglietti che vuole acquistare che la rimozione di essi dall'array

                }

            } catch ( Exception e ) {
                System.out.println("qualcosa è andato storto");
                break;
            }
            
        }

}
}