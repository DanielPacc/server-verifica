package it.fi.meucci;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class App 
{
    public static ArrayList<DThread> trhs = new ArrayList<>();
    public static void main( String[] args ) throws Exception
    {

        ArrayList <Biglietto> ar = new ArrayList<Biglietto>();
        Biglietto b1 = new Biglietto("soppalco1");
        Biglietto b2 = new Biglietto("sottopalco1");
        Biglietto b3 = new Biglietto("tribune1");
        Biglietto b4 = new Biglietto("soppalco2");
        Biglietto b5 = new Biglietto("soppalco3");

        ar.add(b1);
        ar.add(b2);
        ar.add(b3);
        ar.add(b4);
        ar.add(b5);


        DThread.msg = new Messaggio(ar);





       ServerSocket socket = new ServerSocket(6789);

       while(true){
        Socket s = socket.accept();
        System.out.println("Connessione avvenuta.");
        DThread TD = new DThread(s);
        new Thread(TD).start();
        
        trhs.add(TD);
       }
    }
}
