/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class ValidarInput {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        lea.useDelimiter("\n");
        
        do{
            try{
                int x = lea.nextInt();
                System.out.println("x: "+ x);
                break;
            }
            catch(InputMismatchException e){
                lea.next();
                System.out.println("Por favor ingrese un entero");
            }
        }while(true);
    }
}
