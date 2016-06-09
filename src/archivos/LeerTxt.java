/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class LeerTxt {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        System.out.print("Direccion: ");
        String path = lea.nextLine();
        
        try{
            File f = new File(path);
            FileReader fr = new FileReader(f);
            char buffer[] = new char[(int)f.length()];
            int bytes = fr.read(buffer);
            
            System.out.println("Contenido despues de leer "+
                    bytes+": ");
            System.out.println(buffer);
            
            bytes = fr.read(buffer);
            
            System.out.println("Contenido despues de leer "+
                    bytes+": ");
            System.out.println(buffer);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
