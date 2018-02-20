/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stavri Mele
 */
public class ClientMain {
    public static void main(String[] args)
    {
        ClientTCPOgg c=new ClientTCPOgg();
        c.connetti();
        c.parla();
    }   
}
