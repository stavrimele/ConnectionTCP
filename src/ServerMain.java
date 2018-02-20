/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stavri Mele
 */
public class ServerMain {
    public static void main(String[] args)
    {
        ServerTCPOgg s=new ServerTCPOgg();
        s.connetti();
        //s.parla();
    }
    
}
