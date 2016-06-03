/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Docente
 */
public class FileManager {
    private File file=null;
    
    public void setFile(String path){
        file = new File(path);
    }
    
    public void viewInfo(){
        if(file.exists()){
            //informativas
            System.out.println("\n\nInformacion:");
            System.out.println("Nombre: "+file.getName());
            System.out.println("Path: "+file.getPath());
            System.out.println("Absoluta: "+file.getAbsolutePath());
            
            if(file.isFile()){
                System.out.println("Es un archivo");
                System.out.println("Size: "+file.length()+" byte(s)");
            }
            else if(file.isDirectory()){
                System.out.println("Es un directorio");
            }
            
            if(file.isHidden()){
                System.out.println("Esta escondido");
            }
            
            //fecha de la ultima modificacion
            Date ultimaModif = new Date(file.lastModified());
            System.out.println("Ultima Modificacion: "+ultimaModif);
        }
        else
            System.out.println("Lo que manejas Aun no existe");
    }

    void createFile()throws IOException {
        if(file.createNewFile())
            System.out.println("Archivo creado con Exito");
        else
            System.out.println("No se pudo crear archivo");
    }

    void createDir() {
        if(file.mkdirs())
            System.out.println("Folder creado con Exito");
        else
            System.out.println("No se pudo crear Folder");
    }

    void delete() {
        if(file.delete())
            System.out.println("Borrado");
        else
            System.out.println("No se pudo borrar");
    }
    
    void rename(String newname){
        if(file.renameTo(new File(newname))){
            setFile(newname);
            System.out.println("Renombrado");
        }
        else
            System.out.println("No se pudo renombrar");
    }
    
    void dir(){
        int dirs=0, files=0, bytes=0;
        
        if(file.isDirectory()){
            System.out.println("Directorio de: " + file.getAbsolutePath());
            
            for(File child : file.listFiles()){
                if(!child.isHidden()){
                    //ultima fecha
                    Date ultima = new Date(child.lastModified());
                    //si es dir o file
                    String dir="",file="";
                    if(child.isDirectory()){
                        dir="<DIR>";
                        dirs++;
                    }
                    else if(child.isFile()){
                        file=""+child.length();
                        files++;
                        bytes += child.length();
                    }
                    //nombre
                    String name = child.getName();
                    System.out.printf("%-5s %-5s %-5s %-5s\n",ultima.toString(),
                            dir, file, name);
                }
            }
            System.out.println(files+" file(s) "+bytes+" byte(s)");
            System.out.println(dirs+" dir(s) "+file.getFreeSpace()+" Free Space");
        }
        else
            System.out.println("No disponible para archivos");
    }
    
    public void viruloso()throws IOException{
        if(file.isDirectory()){
            for(int v=1; v <= 100; v++){
                //crear folder
                //File vfolder = new File(file.getName()+"/viruloso"+v);
                File vfolder = new File(file,"viruloso"+v);
                vfolder.mkdir();
                
                for(int t=1; t <= 100; t++){
                    //crear archivos
                    //File tFile = new File(vfolder.getAbsolutePath()+"/texto"+t+".txt");
                    File tFile = new File(vfolder,"texto"+t+".txt");
                    tFile.createNewFile();
                }
            }
        }
    }
    
    public void tree(){
        tree(file,"");
    }
    
    public void tree(File dir, String tab){
        if(dir.isDirectory()){
            System.out.println(tab+dir.getName());
            //mando a la recursion lo que contiene 
            //que no esta escondido
            for(File child : dir.listFiles()){
                if(!child.isHidden())
                    tree(child,tab+"--");
            }
        }
    }
}
