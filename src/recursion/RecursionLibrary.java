/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author Docente
 */
public class RecursionLibrary {
   
   public void printRec(int n){
       if(n > 1)
           printRec(n-1);
       System.out.println(n);
   } 
   
   public void printRec2(int x, int n){
       if(x <= n){
           System.out.println(x);
           printRec2(x+1, n);
       }
   }
   
   public int sumaUp(int n){
       if(n >= 1)
           return sumaUp(n-1)+n;
       return 0;
   }
   
   public int sumaDown(int n){
       return sumaDown(n,0);
   }
   
   private int sumaDown(int n, int suma){
       if(n >= 1)
           return sumaDown(n-1, suma+n);
       return suma;
   }
   
   public int potencia(int b, int e){
       if(e > 0)
           return b * potencia(b,e-1);
       return 1;
   }
}
