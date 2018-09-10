/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.proyectServer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;


/**
 *
 * @author estevan
 */
public class Resources {
    
    static String inputLine;
    /**
     * Método creador de la clase
     * @param inputLine URL del recurso solicitado
     */
    public Resources(String inputLine){
        this.inputLine=inputLine;
    }
    
    /**
     * Metodo que selecciona que recurso se va a cargar 
     * @return source recurso solicitado
     * @throws  java.io.IOException excepcion
     */
    static String sources() throws IOException{
        String outputLine = null;        
        System.out.println("ReceivedDDDD: " + inputLine);
        if(inputLine.contains(".jpg")){     
            outputLine =leer("Resources/imagen.jpg")+                                 
            "<img src=\"http://teinco.edu.co/wp-content/uploads/2018/03/img_tecnisisi.jpg\" />"+ "</body>"+ "</html>" ;                                              
            }           
        else if(inputLine.contains("index")){                                   
            outputLine=leer("Resources/index.html");            
        } 
        else if(inputLine==null){ 
            outputLine="ERROR 404  -  Not found";
        }
        else{
            outputLine="ERROR 404  -  Not found";
        }        
        return outputLine;
    }
    
    /**
     * Metodo que selecciona que recurso se va a cargar 
     * @param archivo url del archivo que se caragara
     * @throws  java.io.FileNotFoundException excepcion
     */
    public static String leer(String archivo) throws FileNotFoundException, IOException {
        String cadena; 
        String data ="HTTP/1.1 200 OK\r\n"
            + "Content-Type: text/html\r\n"
            + "\r\n";
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        
        while((cadena =b.readLine())!=null) {             
            data+="\n"+cadena;           
        }         
        b.close();        
        return data;
    }
        
}
