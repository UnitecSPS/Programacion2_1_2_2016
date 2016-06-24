/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pautas.exa2;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author mac
 */
public class EmailAccount {
    //No habia que hacer--------
    RandomAccessFile rusers, remails=null;
    String currentUser=null;
    
    public EmailAccount(){
        try {
            rusers = new RandomAccessFile("usuarios.eml","rw");
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
    //-----
    
    public void setCurrent(String user){
        try{
            remails = new RandomAccessFile(user+"_emails.eml", "rw");
            currentUser = user;
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    boolean login(String username, String pass)throws IOException{
        rusers.seek(0);
        while(rusers.getFilePointer() < rusers.length()){
            String u = rusers.readUTF();
            String p = rusers.readUTF();
            long pos = rusers.getFilePointer();
            rusers.readLong();
            boolean act = rusers.readBoolean();
            
            if(username.equals(u) && pass.equals(p) && act){
                rusers.seek(pos);
                rusers.writeLong(Calendar.getInstance().getTimeInMillis());
                setCurrent(u);
                return true;
            }
        }
        
        return false;
    }
    
    boolean crearAccount(String username, String pass)throws IOException{
        rusers.seek(0);
        
        while(rusers.getFilePointer() < rusers.length()){
            if(username.equals(rusers.readUTF()))
                return false;
            rusers.readUTF();
            rusers.skipBytes(9);
        }
        
        rusers.writeUTF(username);
        rusers.writeUTF(pass);
        rusers.writeLong(Calendar.getInstance().getTimeInMillis());
        rusers.writeBoolean(true);
        setCurrent(username);
        
        return true;
    }
    
    void recibirEmail(String from, String subject, String content)throws IOException{
        try{
            remails.seek(0);
            int cod = 0;
            
            while(remails.getFilePointer() < remails.length()){
                cod = remails.readInt();
                remails.readLong();
                remails.readUTF();
                remails.readUTF();
                remails.readUTF();
                remails.readBoolean();
            }
            
            //escribir
            remails.writeInt(cod+1);
            remails.writeLong(Calendar.getInstance().getTimeInMillis());
            remails.writeUTF(from);
            remails.writeUTF(subject);
            remails.writeUTF(content);
            remails.writeBoolean(false);
        }
        catch(NullPointerException e){
            System.out.println("Login Primero");
        }
    }
    
    void inbox()throws IOException{
        try{
            int ce=0, cesl = 0;
            remails.seek(0);
            while(remails.getFilePointer() < remails.length()){
                int c = remails.readInt();
                remails.readLong();
                String f = remails.readUTF();
                String s = remails.readUTF();
                remails.readUTF();
                boolean l = remails.readBoolean();
                ce++;
                System.out.println(c+"-"+f+"-"+s+"-"+(l ? "Leido" : "No Leido"));
                if(!l)
                    cesl++;
            }
            System.out.println("c:"+ce+"csl:"+cesl);
        }
        catch(NullPointerException e){
            System.out.println("Login Primero");
        }
    }
    
    void leer(int cod, boolean export)throws IOException{
        try{
            remails.seek(0);
            while(remails.getFilePointer() < remails.length()){
                int c = remails.readInt();
                long fe = remails.readLong();
                String from = remails.readUTF();
                String sub = remails.readUTF();
                String con = remails.readUTF();
                boolean l = remails.readBoolean();
                
                if(c == cod){
                    Date f = new Date(fe);
                    String data = f + from + sub + con;
                    System.out.println(data);
                    //actualizo leido
                    remails.seek(remails.getFilePointer()-1);
                    remails.writeBoolean(true);
                    //export
                    try(FileWriter fw = new FileWriter(from+fe+".txt")){
                        fw.write(data);
                    }
                    break;
                }
            }
        }
        catch(NullPointerException e){
            System.out.println("Login primero");
        }
    }
    
    void desactivar()throws IOException{
        Calendar hace2 = Calendar.getInstance();
        hace2.add(Calendar.YEAR, -2);
        
        rusers.seek(0);
        while(rusers.getFilePointer() < rusers.length()){
            rusers.readUTF();
            rusers.readUTF();
            long pos = rusers.getFilePointer();
            long fe = rusers.readLong();
            
            if(fe <= hace2.getTimeInMillis()){
                rusers.writeBoolean(false);
            }
            else
                rusers.readBoolean();
        }
    }
}
