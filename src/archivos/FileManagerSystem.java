/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class FileManagerSystem {
    
    static FileManager manager = new FileManager();
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        int op=0;
        
        do{
            System.out.println("1- Set el Path");
            System.out.println("2- Ver Informacion");
            System.out.println("7- Salir");
            System.out.print("Escoja opcion: ");
            
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Por favor ingrese una opcion correcta");
            }
            
        }while(op!=7);
    }
}
