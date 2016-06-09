/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.jtunes;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Docente
 */
public class JTunes {
    
    private RandomAccessFile rss, rcs;
    
    
    //FORMATO DE ARCHIVOS
    //Todos los archivos los vamos a guardar dentro de un
    //folder llamado: data
   
    /*
        codes.jtn
    ---------------------
    int cod sec de la cancion
    int cod sec del download
    
        songs.jtn
    -----------------------
    int cod cancion
    String nom cancion
    String artista
    String genero
    double monto
    int cant reviews
    int suma de estrellas
    int suma downloads
    boolean dispo
    
        data/downloads/invoice_cod.jtn
    -----------------------------------------
    String cliente
    long fecha
    --* repetitivo
    int cod cancion
    double precio
    */
    
    /**
     * Instanciar el RAF que se conecte a las canciones y
     * otro con los codigos.
     */
    public JTunes(){
        try{
            new File("data").mkdir();
            rss = new RandomAccessFile("data/songs.jtn", "rw");
            rcs = new RandomAccessFile("data/codes.jtn", "rw");
            initCodes();
        }
        catch(Exception e){}
    }

    private void initCodes()throws IOException {
        if(rcs.length() == 0){
            rcs.writeInt(1);
            rcs.writeInt(1);
        }
    }
    
    void addNewSong(String ns, String na, Genero gen, double prec){
        
    }

    void listSongsAvailables() {
        
    }
    
    void viewSongInfo(int cod){
        
    }
    
    boolean changeSongPrice(int cod, double newPrice){
        return false;
    }
    
    void reviewSong(int cod, int stars){
        
    }
}
