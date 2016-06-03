/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class EscritorDeTxt {
    public static void main(String[] args) {
        do{
            Scanner lea = new Scanner(System.in);
            System.out.print("Direccion: ");
            String path = lea.nextLine();
            System.out.println("Append? (si|no): ");
            String append = lea.nextLine().toLowerCase();
            
            try(FileWriter fw = new FileWriter(path,append.equals("si"))){

                do{
                    System.out.println("Texto: ");
                    String texto = lea.nextLine();
                    
                    if(texto.equals(":wq"))
                        break;
                    
                    fw.write(texto+"\r\n");
                    //fw.flush();
                }while(true);
                
                //fw.close();
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }while(true);
    }
}
