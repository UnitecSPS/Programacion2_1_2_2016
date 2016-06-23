/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.exa2;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 *
 * @author mac
 */
public class EmailAccount {
    //No habia que hacer--------
    RandomAccessFile rusers, remail=null;
    String currentUser=null;
    
    public EmailAccount(){
        try {
            rusers = new RandomAccessFile("usuarios.eml","rw");
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
    //-----
    
    public void setCurrent(){
        
    }
    
    boolean login(String username, String pass){
        return false;
    }
    
    boolean crearAccount(String username, String pass){
        return false;
    }
    
    void recibirEmail(String from, String subject, String content){
        
    }
    
    void inbox(){
        
    }
    
    void leer(int cod, boolean export){
        
    }
    
    void desactivar(){
        
    }
}
