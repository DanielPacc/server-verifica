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
                
                outversoClient.writeBytes(mess + "\n");

                /*JSONMapper prende l'oggetto JSON dalla Stringa
                bgl = mapper.readValue(str, Biglietto.class);

                // Manipolazione del messaggio
                bgl.setInfoB(bgl.getInfoB().toUpperCase());

                //Rimanda il dato indietro
                String toSend = mapper.writeValueAsString(bgl);
                outversoClient.writeBytes(toSend + "\n");*/
            } catch ( Exception e ) {
                System.out.println("cazoooo");
                break;
            }
            
        }

}
}