/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class TestRec {
    public static void main(String[] args) {
        RecursionLibrary rl = new RecursionLibrary();
        Scanner lea = new Scanner(System.in);
        int op, num;
        
        do{
            System.out.println("\nMENU\n-----------");
            System.out.println("1- Impriminir 1 a n");
            System.out.println("2- Sumatoria 1 a n");
            System.out.println("3- Potencia");
            System.out.println("Escoja Opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    System.out.print("valor: ");
                    num = lea.nextInt();
                    rl.printRec(num);
                    System.out.println("Ahora el otro  \n---");
                    rl.printRec2(1, num);
                    break;
                case 2:
                    System.out.print("valor: ");
                    num = lea.nextInt();
                    System.out.println("Suma Up: "+ rl.sumaUp(num));
                    System.out.println("Suma Down: "+ rl.sumaDown(num));
                    break;
            }
        }while(op!=8);
        
        
        
    }
}
