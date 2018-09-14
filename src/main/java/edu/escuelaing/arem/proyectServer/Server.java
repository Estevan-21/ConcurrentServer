/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.proyectServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2109950
 */
public class Server extends Thread{
    ServerSocket serverSocket;
    public void Server(ServerSocket serverSocket){
        this.serverSocket=serverSocket;
    }
                        
    /**
     * Método Principal del programa
     * @param args args
     * @throws  java.io.IOException excepcion
     */
    @Override
    public void run(){   
        
            

            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            ReaderWriter reader=new ReaderWriter(clientSocket);
            try {
                reader.read();
            } catch (IOException ex) {
                Logger.getLogger(ProyectServer.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {        
                clientSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(ProyectServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                serverSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(ProyectServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 }      
    
    
    
     



