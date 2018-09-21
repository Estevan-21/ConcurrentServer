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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estevan Vargas
 */
public class ProyectServer {   
    public static void main(String[] args) throws Exception {
       ExecutorService ex = Executors.newFixedThreadPool(100);
       Server server;
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
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
                server = new Server(clientSocket); 
            ex.execute(server);   
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
                     
                        
            serverSocket.close();
       }
       //ex.shutdown();
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

