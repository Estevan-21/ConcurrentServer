/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.proyectServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Estevan Vargas
 */
public class ProyectServer {   
    
    /**
     * Método Principal del programa
     * @param args args
     * @throws  java.io.IOException excepcion
     */
    public static void main(String[] args) throws IOException {     
        while(true){

        ServerSocket serverSocket = null;
        
        try {   
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port: "+getPort());
            System.exit(1);
        }
              
        Socket clientSocket = null;
        try {
            System.out.println("Listo para recibir ... HOLA");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        
        ReaderWriter reader=new ReaderWriter(clientSocket);
        reader.read();
                                                
        clientSocket.close();        
        serverSocket.close();
        }
    }       
    
    
    
     /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     * @return Port
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }


}

