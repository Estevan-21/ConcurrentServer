/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.proyectServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author 2109950
 */
public class Client {
    
    public static void main(String[] args) throws Exception {
       ExecutorService ex = Executors.newFixedThreadPool(10);
       URLReader reader;                            
       for(int i = 0;i<100; i++){
            reader = new URLReader("https://shrouded-island-73032.herokuapp.com/index.html"); 
            ex.execute(reader);
        }
        ex.shutdown();

    }
    
}
