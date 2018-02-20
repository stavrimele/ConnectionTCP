
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
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
public class ClientTCPOgg {
    Socket connection = null;
    String serverAddress = "";
    int port;
    PrintWriter out=null;
    Scanner in= null;
    public ClientTCPOgg()
    {   
        //nome o IP del server
        serverAddress="localhost";
        //porta 
        port=2000;   
        //Date now=new Date();
    }
    public void connetti()
    {
        try
        {
        connection = new Socket(serverAddress, port);
        System.out.println("Connessione aperta");
        }
        catch(ConnectException e){
            System.err.println("Server non disponibile!");
        }
        catch(UnknownHostException e1){
            System.err.println("Errore DNS!");
        }

        catch(IOException e2){//
            System.err.println(e2);
            e2.printStackTrace();
        }
    }
    public void parla()
    {
        try
        {
        out = new PrintWriter(connection.getOutputStream());
        out.println("voglio la data");
        out.flush();
        //scrittura su out
        //leggere la risposta
        //lettura dal client
        in = new Scanner(connection.getInputStream());
        System.out.println("sono dentro parla client");
        System.out.println("il server ha detto: " + in.nextLine());
        connection.close();
        }
        catch(IOException e)
        {
            System.out.println("errore I/O");
        }       
    }
}
