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
        int array[] = { 2, 6, 8, 7, 1 };
        int op, num;
        
        do{
            System.out.println("\nMENU\n-----------");
            System.out.println("1- Impriminir 1 a n");
            System.out.println("2- Sumatoria 1 a n");
            System.out.println("3- Potencia");
            System.out.println("4- MCD");
            System.out.println("5- Buscar en Arreglo");
            System.out.println("6- Palindromo");
            System.out.println("7- Fibonacci");
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
                case 3:
                    System.out.print("Base: ");
                    int b = lea.nextInt();
                    System.out.print("Expo: ");
                    int e = lea.nextInt();
                    System.out.println("Pot Up: "+rl.potencia(b, e));
                    System.out.println("Pot Down: "+rl.potDown(b, e));
                    break;
                case 4:
                    System.out.print("N1: ");
                    int n1 = lea.nextInt();
                    System.out.print("N2: ");
                    int n2 = lea.nextInt();
                    System.out.println("MCD: "+ rl.mcd(n1,n2));
                    break;
                case 5:
                    System.out.println("Numero a buscar: ");
                    if( rl.search(array, lea.nextInt()))
                        System.out.println("Si existe");
                    else
                        System.out.println("No Existe");
                    break;
                case 6:
                    System.out.println("Cadena: ");
                    if(rl.palindromo(lea.next()))
                        System.out.println("Es Palindromo");
                    else
                        System.out.println("No es Palindromo");
                    break;
                case 7:
                    System.out.println("Numero: ");
                    int fibo = rl.fibonacci(lea.nextInt());
                    System.out.println("Fibonacci: "+fibo);
            }
        }while(op!=8);
        
        
        
    }
}
