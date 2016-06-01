/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
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

    void createFile() {
        //intenta crear un archivo
        //como es booleana, se imprime si se pudo crear
        //o no. Cualquier error se deja propagar
    }
}
