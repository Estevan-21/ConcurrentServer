/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.proyectServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author 2109950
 */
public class URLReader extends Thread {
    URL url;
    
    public URLReader(String url) throws MalformedURLException { 
      this.url=new URL(url);
    } 

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);            
            }   
        } catch (IOException x) {
            System.err.println(x);
        }                        
    }
    
}
