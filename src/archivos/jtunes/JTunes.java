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
    
    public final static long SONG_OFFSET = 0;
    public final static long DOWNLOAD_OFFSET = 4;
    
    
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
    
    private int getCode(long offset) throws IOException{
        rcs.seek(offset);
        int code = rcs.readInt();
        rcs.seek(offset);
        rcs.writeInt(code+1);
        return code;
    }
    
    void addNewSong(String ns, String na, Genero gen, double prec) throws IOException{
        rss.seek(rss.length());
        //codigo
        int code = getCode(SONG_OFFSET);
        rss.writeInt(code);
        //nombre
        rss.writeUTF(ns);
        //artista
        rss.writeUTF(na);
        //genero
        rss.writeUTF(gen.name());
        //precio
        rss.writeDouble(prec);
        //cant revs
        rss.writeInt(0);
        //suma stars
        rss.writeInt(0);
        //downloads
        rss.writeInt(0);
        //available
        rss.writeBoolean(true);
    }

    /**
     * Imprimir CODE-NS-NA-PRECIO
     */
    void listSongsAvailables()throws IOException {
        rss.seek(0);
        System.out.println("\nAVAILABLE SONGS\n----------");
        while(rss.getFilePointer() < rss.length()){
            int code = rss.readInt();
            String ns = rss.readUTF();
            String na = rss.readUTF();
            rss.readUTF();//genero
            double p = rss.readDouble();
            rss.skipBytes(12);
            if(rss.readBoolean()){
                System.out.println(code+"-"+ns+"-"+na+" $"+p);
            }
        }
    }
    
    /**
     * Buscar la cancion que coincide con ese codigo
     * SI lo encuentro retorno true y dejo el puntero
     * justo DESPUES del codigo
     * @param code Codigo de la cancion
     * @return Si lo encontre o no
     * @throws IOException 
     */
    boolean searchSong(int code)throws IOException{
        rss.seek(0);
        
        while(rss.getFilePointer() < rss.length()){
            if(rss.readInt() == code){
                return true;
            }
            //movemos el puntero hasta el final del archivo
            rss.readUTF();//ns
            rss.readUTF();//na
            rss.readUTF();//gen
            rss.skipBytes(21);//lo que resta
        }
        return false;
    }
            
    
    void viewSongInfo(int cod) throws IOException{
        if(searchSong(cod)){
            //lo encontre! y el puntero esta justo
            //al inicio del nombre
            String ns = rss.readUTF();
            String na = rss.readUTF();
            String gen = rss.readUTF();
            double p = rss.readDouble();
            int cr = rss.readInt();
            int stars = rss.readInt();
            int cd = rss.readInt();
            boolean status = rss.readBoolean();
            
            double review=0;
            if(cr > 0)
                review = stars/cr;
            
            System.out.println(ns+" by "+na);
            System.out.println("$"+p);
            System.out.println("Review: "+review);
            System.out.println(cd+" veces bajada.");
            System.out.println("Esta cancion esta"+
                    (status ? "" : "no")+" disponible");
        }
        else
            System.out.println("Cancion No existe");
    }
    
    boolean changeSongPrice(int cod, double newPrice){
        
        return false;
    }
    
    boolean changeState(int cod){
        return false;
    }
    
    void reviewSong(int cod, int stars)throws IOException{
        if(stars <0 || stars >5){
            System.out.println("Review Erroneo");
            return;
        }
        
        rss.seek(0);
        
        while(rss.getFilePointer() < rss.length()){
            int n = rss.readInt();
            String no = rss.readUTF();
            String na = rss.readUTF();
            rss.readUTF();
            rss.readDouble();
            //guardo la pos antes de los datos de review
            long pos = rss.getFilePointer();
            int cr = rss.readInt();
            int ce = rss.readInt();
            
            if(n == cod){
                rss.seek(pos);
                rss.writeInt(cr+1);
                rss.writeInt(ce+stars);
                System.out.println(no+" by "+na+" ha sido calificada.");
                return;
            }
            
            rss.skipBytes(5);
        }
    }
    
    private DownloadItem readyForDownload(int cod)throws IOException{
        if(searchSong(cod)){
            String nc = rss.readUTF();
            String na = rss.readUTF();
            rss.readUTF();
            double p = rss.readDouble();
            rss.skipBytes(8);
            long pos = rss.getFilePointer();
            int cd = rss.readInt();
            
            if(rss.readBoolean()){
                rss.seek(pos);
                rss.writeInt(cd+1);
                return new DownloadItem(nc, na, p);
            }
        }
        return null;
    }
}
