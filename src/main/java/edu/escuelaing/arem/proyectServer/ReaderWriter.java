/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.proyectServer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.imageio.ImageIO;

/**
 *
 * @author estevan
 */
public class ReaderWriter {
        
    Socket clientSocket = null;
    /**
     * Método Creador de la clase
     * @param Socket socket por donde se esucha y se habla   
     */
    ReaderWriter(Socket clientSocket){
        this.clientSocket=clientSocket;
    }
    
    /**
     * Método que lee las peticiones del browser
     * @throws  java.io.IOException excepcion
     */
    public void read() throws IOException{
    
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader in = new BufferedReader(
        new InputStreamReader(clientSocket.getInputStream()));
        
        String inputLine="abc";
        String  outputLine=null;
        
        Resources data=new Resources(in.readLine());
        outputLine=data.sources();                
        while ((inputLine = in.readLine()) != null) {   
            if(inputLine==null){
                System.out.println("NULLLLLLLLLLLLLL");
            }
            System.out.println("Received: " + inputLine+"|");                
            if (!in.ready()) {       
                break;
            }        
        }
    out.println(outputLine);        
    out.close();        
    in.close();
    }
    
   
}
