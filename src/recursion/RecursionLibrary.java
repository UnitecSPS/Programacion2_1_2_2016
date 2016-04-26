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
}
