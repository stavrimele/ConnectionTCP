

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stavri Mele
 */
public class ServerTCPOgg {
    int port;
    Scanner in;
    PrintWriter out;
    Date now;
    //oggetto ServerSocket necessario per accettare richieste dal client
    ServerSocket sSocket;
    //oggetto da usare per realizzare la connessione TCP
    Socket connection;
    public ServerTCPOgg()
    {
        port=2000;
        in=null;
        out=null;
        now=null;
        sSocket=null;
    }
    public void connetti()
    {
        try{
            // il server si mette in ascolto sulla porta voluta
            sSocket = new ServerSocket(port);
            System.out.println("In attesa di connessioni!");
            //si è stabilita la connessione
            connection = sSocket.accept();
            sSocket.close();
            System.out.println("Connessione stabilita!");
            System.out.println("Socket server: " + connection.getLocalSocketAddress());
            System.out.println("Socket client: " + connection.getRemoteSocketAddress());
            //lettura dal client
            in = new Scanner(connection.getInputStream());
            System.out.println("il client ha detto: " + in.nextLine());   
        }
           catch(Exception e){
               System.err.println("Errore di I/O!");
        }
        now=new Date();
        try
        {
        out = new PrintWriter(connection.getOutputStream());
        out.println(String.valueOf(now));
        out.flush();
        connection.close();
        }
        catch(IOException e)
        {
            System.err.println("Errore di I/O! parla");
        } 
        
    }
    public void parla()
    {
        
    }
}
